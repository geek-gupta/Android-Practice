package com.company.gaurav.mockserver.services;

import com.company.gaurav.mockserver.model.Teacher;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by gaurav on 2/12/17.
 */

public interface IRestService {

    String ENDPOINT = "http://www.gaurav.com/";

    @GET("/")
    Call<Teacher> getTeacherById(@Query("id") final String id);
}