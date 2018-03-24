package com.codingblocks.imagecropper;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;

public class Main2Activity extends AppCompatActivity {
    int REQUEST_CODE_PERMISSION = 213;
    int REQUEST_CODE_CAMERA = 321;
    ImageView imageView;
    File f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = (ImageView) findViewById(R.id.imageView);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_CODE_PERMISSION);
        } else {
            launchCamera();
        }
    }
    void launchCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        f = new File(Environment.getExternalStorageDirectory(),
                "newFile" + System.currentTimeMillis() + ".jpg");
        Uri mySavePath = FileProvider.getUriForFile(this, getPackageName() + ".provider", f);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mySavePath);
        cameraIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivityForResult(cameraIntent, REQUEST_CODE_CAMERA);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSION) {
            launchCamera();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CAMERA && resultCode == Activity.RESULT_OK) {
            if (f.exists()) {
                imageView.setImageBitmap(BitmapFactory.decodeFile(f.getAbsolutePath()));
            }
            if (data != null) {
                Bundle extras = data.getExtras();
                if (extras != null) {
                    for (String key : extras.keySet()) {
                        Object value = extras.get(key);
                        Log.d("Camera_APP", String.format("%s %s (%s)", key,
                                value.toString(), value.getClass().getName()));
                    }
                }
                Bitmap bitmap = (Bitmap) extras.get("data");
                if (bitmap != null)
                    imageView.setImageBitmap(bitmap);

                if (data.getData() != null) {
                    Uri resultUri = data.getData();
                    imageView.setImageURI(resultUri);
                }
            }
        }
    }
}
