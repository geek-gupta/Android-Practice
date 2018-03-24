package com.example.gaurav.hypemessanger.SplashScreen;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.gaurav.hypemessanger.R;
import com.example.gaurav.hypemessanger.Register.LoginActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        getSupportActionBar().hide();

        Timer timer = new Timer();
        timer.execute();

    }
    class Timer extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            long time1 = System.currentTimeMillis();
            while(System.currentTimeMillis()-time1<=3000);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            super.onPostExecute(aVoid);
            Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
