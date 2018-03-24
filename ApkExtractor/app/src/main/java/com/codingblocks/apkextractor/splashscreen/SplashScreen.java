package com.codingblocks.apkextractor.splashscreen;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.codingblocks.apkextractor.MainActivity;
import com.codingblocks.apkextractor.R;


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
            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
