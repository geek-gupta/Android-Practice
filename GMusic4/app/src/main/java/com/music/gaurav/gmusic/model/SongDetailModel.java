package com.music.gaurav.gmusic.model;

/**
 * Created by gaurav on 11/4/2017.
 */

public class SongDetailModel {
    private String songTitle;
    private String songArtist;
    private String songDuration;
    private String songStoragePath;
    private String songAlbum;
    private String songType;
    private String songSize;

    public SongDetailModel(String songTitle, String songArtist,
                           String songDuration, String songStoragePath, String songAlbum, String songType, String songSize) {
        this.songTitle = songTitle;
        this.songArtist = songArtist;
        this.songDuration = songDuration;
        this.songStoragePath = songStoragePath;
        this.songAlbum = songAlbum;
        this.songType = songType;
        this.songSize = songSize;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongArtist() {
        return songArtist;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getSongStoragePath() {
        return songStoragePath;
    }

    public void setSongStoragePath(String songStoragePath) {
        this.songStoragePath = songStoragePath;
    }

    public String getSongAlbum() {
        return songAlbum;
    }

    public void setSongAlbum(String songAlbum) {
        this.songAlbum = songAlbum;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getSongSize() {
        return songSize;
    }

    public void setSongSize(String songSize) {
        this.songSize = songSize;
    }
}
