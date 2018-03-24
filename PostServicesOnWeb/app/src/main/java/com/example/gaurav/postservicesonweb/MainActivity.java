package com.example.gaurav.postservicesonweb;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText et1,et2;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnClick);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        txtView = (TextView) findViewById(R.id.textView);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input1 = et1.getText().toString();
                String input2 = et2.getText().toString();
                NetworkConnection ntconn = new NetworkConnection();
                ntconn.execute(input1,input2);
            }
        });
    }
    class NetworkConnection extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {

            String name = params[0];
            String job = params[1];
            HttpURLConnection conn = null;
            URL url;

            try {
                url = new URL("https://reqres.in/api/users");
                conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setReadTimeout(2000);//Default 15 sec
                conn.setConnectTimeout(1000);//Default 10 sec
                conn.setDoOutput(true);
                String serverSendBody = "{\"name\": \"morpheus\",\"job\": \"leader\"}";

                OutputStream os = conn.getOutputStream();
                os.write(serverSendBody.getBytes());
                os.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
                //String input=et1.getText().toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                int responseCode = conn.getResponseCode();
                InputStream is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = "";
                StringBuilder builder = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    builder.append(line);
                    builder.append("\n");
                }
                return builder.toString();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

                txtView.setText(s);
        }
    }
}
