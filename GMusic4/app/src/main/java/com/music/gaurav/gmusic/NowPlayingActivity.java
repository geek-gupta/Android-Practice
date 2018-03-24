package com.music.gaurav.gmusic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.music.gaurav.gmusic.model.SongsModel;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity implements Serializable {

    private Intent intent;
    private String songName;
    private String artistName;
    private int duration;
    private Bitmap songAlbumArt = null;
    private Uri songAlbumArtUri;
    private long albumId;
    private String data;
    private ImageView songImage;
    private TextView songNameView;
    private TextView artistNameView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        songImage = (ImageView) findViewById(R.id.song_image);
        songNameView = (TextView) findViewById(R.id.song_name_field);
        artistNameView = (TextView) findViewById(R.id.artist_name_field);

        intent = getIntent();
        songName = intent.getStringExtra("SONG_NAME");
        artistName = intent.getStringExtra("ARTIST_NAME");
        duration = intent.getIntExtra("DURATION",0);
        songAlbumArtUri = Uri.parse(intent.getStringExtra("ALBUM_ART_URI"));
        albumId = intent.getLongExtra("SONG_ALBUM_ID",0);
        data = intent.getStringExtra("SONG_DATA");

        try {
            songAlbumArt = MediaStore.Images.Media.getBitmap(this.getContentResolver(), songAlbumArtUri);
        } catch (IOException e) {
            e.printStackTrace();
        }


        songImage.setImageBitmap(songAlbumArt);
        songNameView.setText(songName);
        artistNameView.setText(artistName);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.now_playing_menu, menu);
        return true;
    }




}
