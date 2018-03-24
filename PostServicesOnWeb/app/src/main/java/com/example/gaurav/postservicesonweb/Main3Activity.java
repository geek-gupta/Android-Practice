package com.example.gaurav.postservicesonweb;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.example.gaurav.postservicesonweb.model.CourseModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    TextView tvResult;
    Button btnVolley;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        tvResult = (TextView) findViewById(R.id.txtView);
        btnVolley = (Button) findViewById(R.id.btnVolley);
        final String url = "http://www.example.com/";
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

       btnVolley.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String json = getAssetByFilename("test.json");
               Gson gson = new Gson();
               ArrayList<CourseModel> courses = new ArrayList<CourseModel>();
               try {
                   JSONObject jsonObject = new JSONObject(json);
                   JSONArray coursesArray = jsonObject.getJSONArray("courses");
                   for(int i=0;i<coursesArray.length();i++){
                       CourseModel course = gson.fromJson(coursesArray.get(i).toString(),CourseModel.class);

                       courses.add(course);
                   }

                    tvResult.setText(courses.get(0).getName());
               } catch (JSONException e) {
                   e.printStackTrace();
               }
               //JsonArrayRequest  jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,url,)
           }
       });
    }
    String getAssetByFilename(String filename){
        AssetManager as = getAssets();
        try {
            InputStream is = as.open(filename);

            BufferedReader  br = new BufferedReader(new InputStreamReader(is));
            String line ="";
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine())!=null){
                builder.append(line);
                builder.append("\n");
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
