package com.music.gaurav.gmusic.songs;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.music.gaurav.gmusic.NowPlayingActivity;
import com.music.gaurav.gmusic.R;
import com.music.gaurav.gmusic.model.SongsModel;

import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by gaurav on 11/3/2017.
 */

public class SongsFragment extends Fragment {

    private static final int MY_PERMISSION_REQUEST = 1;
    ArrayList<SongsModel> songModels;
    SongsAdapter songAdapter;
    RecyclerView songsRecyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.songs_fragment_layout,container,false);
        songsRecyclerView = (RecyclerView) view.findViewById(R.id.song_recycler_view);
        if(ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.READ_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(getActivity()
                        ,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }else{
                ActivityCompat.requestPermissions(getActivity()
                        ,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},MY_PERMISSION_REQUEST);
            }
        }else {
            doStuff();

        }


        return view;
    }

    private void doStuff() {
        songModels = new ArrayList<>();

        LoadDataTask loadDataTask = new LoadDataTask();
        loadDataTask.execute();
        songAdapter = new SongsAdapter(getActivity(),songModels);
        songsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        songsRecyclerView.setAdapter(songAdapter);
    }

    private void getMusic(){
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

// Columns
        String[] select = {
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.ARTIST,
                MediaStore.Audio.Media.ALBUM,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA,
                MediaStore.Audio.Media.ALBUM_ID,
                MediaStore.Audio.Media.DURATION
        };

// Where
        String where = MediaStore.Audio.Media.IS_MUSIC + "=1";

// Perform the query
        Cursor cursor = getContext().getContentResolver().query(uri, select, where, null, null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                long albumId = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
                String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
                String track = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                String data = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));

                final Uri ART_CONTENT_URI = Uri.parse("content://media/external/audio/albumart");
                Uri albumArtUri = ContentUris.withAppendedId(ART_CONTENT_URI, albumId);

                Bitmap bitmap = null;
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), albumArtUri);
                } catch (Exception exception) {
                    // log error
                }
                songModels.add(new SongsModel(track,artist,duration,bitmap,albumId,data));
                cursor.moveToNext();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode){
            case MY_PERMISSION_REQUEST:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if(ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(getActivity(), "Permission Granted", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getActivity(), "No Permission Granted", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
                return;
        }
    }

    public class LoadDataTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {

            getMusic();

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            songAdapter.notifyDataSetChanged();


        }
    }

}
