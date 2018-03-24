package com.example.gaurav.vision;


import android.support.v7.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class Garbage_cleaning_activity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout hiddenUploadLayout;
    RelativeLayout garbageMessage;
    EditText message;
    Button picsUpload,videoUpload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garbage_cleaning_activity);
        hiddenUploadLayout = (LinearLayout) findViewById(R.id.hiddenUploadLayout);
        garbageMessage = (RelativeLayout) findViewById(R.id.garbageMessage);
        picsUpload = (Button) findViewById(R.id.PicsUpload);
        videoUpload = (Button) findViewById(R.id.videoUploadButton);
        picsUpload.setOnClickListener(this);
        videoUpload.setOnClickListener(this);
        garbageMessage.setBackgroundColor(Color.WHITE);
        ActionBar v = getSupportActionBar();
        v.setTitle("Garbage Collection");


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.PicsUpload:
                hiddenUploadLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.videoUploadButton:
                hiddenUploadLayout.setVisibility(View.VISIBLE);
                break;
        }
    }
}
