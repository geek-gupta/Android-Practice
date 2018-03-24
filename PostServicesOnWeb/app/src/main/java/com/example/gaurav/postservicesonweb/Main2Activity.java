package com.example.gaurav.postservicesonweb;

import android.nfc.NfcAdapter;
import android.service.voice.VoiceInteractionSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.gaurav.postservicesonweb.model.CourseModel;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    TextView tvResult;
    Button btnVolley,btnVolley2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        tvResult = (TextView) findViewById(R.id.txtView);
        btnVolley = (Button) findViewById(R.id.btnVolley);
        btnVolley2= (Button) findViewById(R.id.btnVolley2);
        final String url="http://www.example.com/";
        final String url2 ="https://reqres.in/api/users";
       btnVolley.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

                   @Override
                   public void onResponse(String response) {
                       tvResult.setText(response);
                   }
               }, new Response.ErrorListener() {
                   @Override
                   public void onErrorResponse(VolleyError error) {
                       tvResult.setText("Error can't find the url");
                   }
               });

               requestQueue.add(stringRequest);
               //can add multiple requests
               requestQueue.add(stringRequest);
           }
       });

        btnVolley2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CourseModel courseModel = new CourseModel();
                courseModel.setName("gaurav");
                courseModel.setJob("Engineer");
                Gson gson = new Gson();
                try {
                    JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.POST, url2, new JSONObject(gson.toJson(courseModel, CourseModel.class).toString()),
                            new Response.Listener() {
                                @Override
                                public void onResponse(Object response) {

                                    tvResult.setText(courseModel.getName());
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    });
                    requestQueue.add(jsonRequest);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
