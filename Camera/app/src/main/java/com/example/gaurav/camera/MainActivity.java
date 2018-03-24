package com.example.gaurav.camera;

import android.hardware.Camera;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";
    Camera cam;
    FrameLayout cameraContainer;
    Button cameraButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraContainer = (FrameLayout) findViewById(R.id.cameraContainer);
        cameraButton = (Button) findViewById(R.id.cameraButton);

        if(cam == null){
            cam = Camera.open();

        }
        List<Camera.Size> picSize = cam.getParameters().getSupportedPictureSizes();
        List<Camera.Size> videoSize = cam.getParameters().getSupportedVideoSizes();
        List<Camera.Size> previewSize = cam.getParameters().getSupportedPreviewSizes();

        int rotation=0;
        switch (getWindowManager().getDefaultDisplay().getRotation()){
            case Surface.ROTATION_0: rotation = 90;
                break;
            case Surface.ROTATION_90: rotation = 0;
                break;
            case Surface.ROTATION_180: rotation = 270;
                break;
            case Surface.ROTATION_270: rotation = 180;
                break;
        }

        cam.getParameters().setRotation(rotation);
        cam.setDisplayOrientation(rotation);
        Log.d(TAG, "picSize : "+picSize);
        Log.d(TAG, "videoSize : "+videoSize);
        Log.d(TAG, "previewSize : "+previewSize);

        CameraPreview cameraPreview = new CameraPreview(this,cam);
        cameraContainer.addView(cameraPreview);
        cameraContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               takePicture();
            }
        });
    }

    void takePicture(){
        Camera.PictureCallback callback = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                Log.d(TAG, "onPictureTaken: "+data.length);
                File mediaFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)+File.separator+"IMG"+System.currentTimeMillis()+".jpg");
                try{
                    FileOutputStream fos = new FileOutputStream(mediaFile);
                    fos.write(data);
                    fos.close();
                }catch (FileNotFoundException e){
                    e.printStackTrace();
                }catch (IOException e){
                    e.printStackTrace();
                }
                cam.stopPreview();
                cam.startPreview();
            }
        };
        cam.takePicture(null,null,callback);
    }
    @Override
    protected void onStop() {
        if(cam!=null){
            cam.release();
        }
        super.onStop();

    }
}
