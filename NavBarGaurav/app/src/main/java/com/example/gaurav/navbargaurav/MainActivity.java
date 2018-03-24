package com.example.gaurav.navbargaurav;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + this.getPackageName()));
        startActivityForResult(intent, 123);

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 123) {
            if(!Settings.canDrawOverlays(MainActivity.this))
                startService(new Intent(this, Service2.class));
            Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
            finish();
        }
            else {
                Toast.makeText(this, "Grant overlay permission", Toast.LENGTH_SHORT).show();
            }
        }
    }

