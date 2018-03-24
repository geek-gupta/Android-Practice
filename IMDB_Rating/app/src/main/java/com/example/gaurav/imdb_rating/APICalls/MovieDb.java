package com.example.gaurav.imdb_rating.APICalls;

import com.example.gaurav.imdb_rating.ResultModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gaurav on 7/18/2017.
 */

public interface MovieDb {
    @GET("movie/top_rated/")
    Call<ResultModel> getMovieList(@Query("api_key") String apikey);
        }