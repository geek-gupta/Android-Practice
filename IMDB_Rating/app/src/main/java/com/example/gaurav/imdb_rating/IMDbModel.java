package com.example.gaurav.imdb_rating;

/**
 * Created by gaurav on 7/18/2017.
 */

public class IMDbModel {
    private String id;
    private String title;
    private String poster_path;
    private String overview;


    public IMDbModel(String id, String title, String poster_path, String overview) {
        this.id = id;
        this.title = title;
        this.poster_path = poster_path;
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
