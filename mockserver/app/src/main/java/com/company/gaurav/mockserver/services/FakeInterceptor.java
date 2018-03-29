package com.company.gaurav.mockserver.services;

import android.util.Log;

import java.io.IOException;
import java.net.URI;

import butterknife.BuildConfig;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by gaurav on 2/12/17.
 */

public class FakeInterceptor implements Interceptor {

    private final static String TAG = FakeInterceptor.class.getSimpleName();

    // FAKE RESPONSES.
    private final static String TEACHER_ID_1 = "{\"id\":1,\"age\":19,\"name\":\"Gaurav kumar\"}";
    private final static String TEACHER_ID_2 = "{\"id\":2,\"age\":23,\"name\":\"Anuj garg\"}";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;

            Log.d(TAG, "---- DEBUG --- DEBUG -- DEBUG - DEBUG -- DEBUG --- DEBUG ----");
            Log.d(TAG, "----                FAKE SERVER RESPONSES                ----");
            String responseString;
            // Get Request URI.
            final URI uri = chain.request().url().uri();
            Log.d(TAG, "---- Request URL: " + uri.toString());
            // Get Query String.
            final String query = uri.getQuery();
            // Parse the Query String.
            final String[] parsedQuery = query.split("=");
            if(parsedQuery[0].equalsIgnoreCase("id") && parsedQuery[1].equalsIgnoreCase("1")) {
                responseString = TEACHER_ID_1;
            }
            else if(parsedQuery[0].equalsIgnoreCase("id") && parsedQuery[1].equalsIgnoreCase("2")){
                responseString = TEACHER_ID_2;
            }
            else {
                responseString = "";
            }

            response = new Response.Builder()
                    .code(200)
                    .message(responseString)
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();

            Log.d(TAG, "---- DEBUG --- DEBUG -- DEBUG - DEBUG -- DEBUG --- DEBUG ----");

        return response;
    }
}