package com.music.gaurav.gmusic.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

/**
 * Created by gaurav on 11/3/2017.
 */

public class SongsModel implements Serializable{

    private String songName;
    private String artistName;
    private int duration;
    private Bitmap songAlbumArt;
    private  long albumId;
    private String data;

    public SongsModel(String songName, String artistName, int duration, Bitmap songAlbumArt, long albumId, String data) {
        this.songName = songName;
        this.artistName = artistName;
        this.duration = duration;
        this.songAlbumArt = songAlbumArt;
        this.albumId = albumId;
        this.data = data;
    }




    public Bitmap getSongAlbumArt() {
        return songAlbumArt;
    }

    public void setSongAlbumArt(Bitmap songAlbumArt) {
        this.songAlbumArt = songAlbumArt;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {

        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

}
