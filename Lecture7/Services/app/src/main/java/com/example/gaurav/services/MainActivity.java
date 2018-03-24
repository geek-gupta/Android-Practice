package com.example.gaurav.services;

import android.app.Service;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnStart,btnStop;
     public static Boolean stop=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnstart);
        btnStop = (Button) findViewById(R.id.btnstop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stop=true;
                Log.d("MainActivity","instart");
                //MyAsyncTask myAsyncTask=new MyAsyncTask();
                //myAsyncTask.execute();


                MainActivity.this.startService(new Intent(MainActivity.this,MyService1.class));

                //Intent startServiceIntent = new Intent(MainActivity.this,MyIntentService.class);
                //startService(startServiceIntent);


            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Stop",Toast.LENGTH_SHORT).show();
                stop=false;
            }
        });
    }

}
