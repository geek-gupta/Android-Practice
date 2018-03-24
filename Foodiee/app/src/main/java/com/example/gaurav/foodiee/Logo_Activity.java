package com.example.gaurav.foodiee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.Delayed;
import java.util.logging.Handler;

public class Logo_Activity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        super.onCreate(savedInstanceState);

        
        setContentView(R.layout.activity_logo_);
        getSupportActionBar().hide();


        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);

                } catch(InterruptedException e) {
                } finally {
                    createDrPopup();
                    finish();
                }
            }
        };
        splashTread.start();
    }

    private void createDrPopup() {
        Intent intent = new Intent(Logo_Activity.this,MainActivity.class);
        overridePendingTransition(20,R.anim.abc_shrink_fade_out_from_bottom);
        startActivity(intent);
    }



}


