package com.example.gaurav.imdb_rating;

import java.util.ArrayList;

/**
 * Created by gaurav on 7/18/2017.
 */

public class ResultModel {
    int page;
    int total_results;
    int total_pages;
    private ArrayList<IMDbModel> results;

    public ResultModel(int page, int total_results, int total_pages, ArrayList<IMDbModel> resultModels) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.results = resultModels;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<IMDbModel> getResults() {
        return results;
    }

    public void setResults(ArrayList<IMDbModel> results) {
        this.results = results;
    }
}
