package com.music.gaurav.gmusic.songs;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.music.gaurav.gmusic.NowPlayingActivity;
import com.music.gaurav.gmusic.R;
import com.music.gaurav.gmusic.model.SongsModel;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by gaurav on 11/3/2017.
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongsViewHolder> {

    Context context;
    ArrayList<SongsModel> songsModel;

    public SongsAdapter(Context context, ArrayList<SongsModel> songsModel) {
        this.context = context;
        this.songsModel = songsModel;
    }

    @Override
    public SongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ((LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.song_list, parent, false);
        return new SongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongsViewHolder holder, final int position) {

        final SongsModel songs = songsModel.get(position);

        holder.songName.setText(songs.getSongName());
        holder.artistName.setText(songs.getArtistName());

        int dur = songs.getDuration();

        int hrs = (dur / 3600000);
        int mns = (dur / 60000) % 60000;
        int scs = dur % 60000;

        NumberFormat formatter = new DecimalFormat("00");
        String seconds = formatter.format(scs);

        final String songTime = String.format("%02d", mns);
        String output = songTime + ":" + seconds;
        holder.timing.setText(output);

        final Bitmap bm = songs.getSongAlbumArt();


        holder.songAlbumArt.setImageBitmap(bm);

        holder.songlist_item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, NowPlayingActivity.class);
                intent.putExtra("SONG_DATA",songs.getData());
                intent.putExtra("SONG_ALBUM_ID",songs.getAlbumId());
                intent.putExtra("ARTIST_NAME", songs.getArtistName());
                intent.putExtra("DURATION", songs.getDuration());
                intent.putExtra("SONG_NAME", songs.getSongName());
                intent.putExtra("ALBUM_ART_URI", songs.getImageUri(context, bm).toString());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return songsModel.size();
    }

    class SongsViewHolder extends RecyclerView.ViewHolder {

        TextView songName, timing, artistName;
        ImageView songAlbumArt;
        LinearLayout songlist_item_layout;

        public SongsViewHolder(View itemView) {
            super(itemView);
            songName = (TextView) itemView.findViewById(R.id.song_name);
            artistName = (TextView) itemView.findViewById(R.id.artist_name);
            timing = (TextView) itemView.findViewById(R.id.timing);
            songAlbumArt = (ImageView) itemView.findViewById(R.id.song_image);
            songlist_item_layout = (LinearLayout) itemView.findViewById(R.id.songlist_item_layout);
        }
    }

}

