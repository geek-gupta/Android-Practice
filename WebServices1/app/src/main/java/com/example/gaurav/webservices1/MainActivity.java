package com.example.gaurav.webservices1;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.security.spec.ECField;

public class MainActivity extends AppCompatActivity {

    Button btnClick;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnClick = (Button) findViewById(R.id.btnClick);
        tvResult = (TextView) findViewById(R.id.tvResult);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PerformNetworkOperation performNetworkOperation = new PerformNetworkOperation();
               // performNetworkOperation.execute("https://reqres.in/api/users/2");
                PerformJsonOperation performJsonOperation = new PerformJsonOperation();
                performJsonOperation.execute("https://reqres.in/api/users/2");
            }
        });
    }

    boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected()){
            return true;
        }
        return false;
    }



    class PerformNetworkOperation extends AsyncTask<String,Float,String>{
        URL url = null;
        HttpURLConnection httpConn=null;
        int requestCode=0;

        @Override
        protected void onProgressUpdate(Float... values) {
            tvResult.setText(String.valueOf(values[0]));
            super.onProgressUpdate(values);
        }

        @Override
        protected String doInBackground(String... params) {
            Float f=2.0f;
            publishProgress(f);
            try {

                url =new URL(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                httpConn = (HttpURLConnection) url.openConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                requestCode = httpConn.getResponseCode();
                if(requestCode == HttpURLConnection.HTTP_OK){
                    InputStream is =httpConn.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(is));
                    StringBuilder builder=new StringBuilder();
                    String lines="";
                    while ((lines=br.readLine())!=null){
                        builder.append(lines);
                        builder.append("\n");
                    }
                    return builder.toString();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return String.valueOf(requestCode);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tvResult.setText(s);
        }
    }


    class PerformJsonOperation extends AsyncTask<String,Float,UserModel>{
        URL url = null;
        HttpURLConnection httpConn=null;
        int requestCode=0;

        @Override
        protected void onProgressUpdate(Float... values) {
            tvResult.setText(String.valueOf(values[0]));
            super.onProgressUpdate(values);
        }

        @Override
        protected UserModel doInBackground(String... params) {
            Float f=2.0f;
            publishProgress(f);
            try {

                url =new URL(params[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                httpConn = (HttpURLConnection) url.openConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                requestCode = httpConn.getResponseCode();
                if(requestCode == HttpURLConnection.HTTP_OK){
                    InputStream is =httpConn.getInputStream();
                    BufferedReader br=new BufferedReader(new InputStreamReader(is));
                    StringBuilder builder=new StringBuilder();
                    String lines="";
                    while ((lines=br.readLine())!=null){
                        builder.append(lines);
                        builder.append("\n");
                    }
                    JSONObject jsonObject=new JSONObject(builder.toString());
                    String dataString = (String) jsonObject.getString(JsonConatants.DATA_KEY);
                    JSONObject dataObject = new JSONObject(dataString);
                    UserModel user = new UserModel(dataObject.getInt(JsonConatants.ID_KEY),
                            dataObject.getString(JsonConatants.FIRST_NAME),
                            dataObject.getString(JsonConatants.LAST_NAME),
                            dataObject.getString(JsonConatants.AVTAR));
                    return user;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(UserModel userModel) {
            super.onPostExecute(userModel);
            if(userModel!=null){
                tvResult.setText(userModel.getFirstName());
            }
        }
    }


}
