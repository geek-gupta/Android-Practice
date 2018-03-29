package com.company.gaurav.mockserver.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit.JacksonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gaurav on 2/12/17.
 */

public  final class RestClient {

    private static IRestService mRestService = null;

    public static IRestService getClient() {
        if(mRestService == null) {
            final OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new FakeInterceptor()).build();

            Gson gson = new GsonBuilder().setLenient()
                    .create();

            final Retrofit retrofit = new Retrofit.Builder()
                    // Using custom Jackson Converter to parse JSON
                    // Add dependencies:
                    // com.squareup.retrofit:converter-jackson:2.0.0-beta2
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    // Endpoint
                    .baseUrl(IRestService.ENDPOINT)
                    .client(client)
                    .build();

            mRestService = retrofit.create(IRestService.class);
        }
        return mRestService;
    }
}