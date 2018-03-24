package com.codingblocks.cameraapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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

    String TAG = "CamraActivity";
    Camera cam;
    int requestCodeCamera = 321;
    FrameLayout container;
    Button capture, video;

    CameraPreview cameraPreview;
    MediaRecorder mediaRecorder;
    boolean isRecording = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cameraPreview = (CameraPreview) findViewById(R.id.preview);

        //container = (FrameLayout) findViewById(R.id.container);
        capture = (Button) findViewById(R.id.capture);
        video = (Button) findViewById(R.id.video);

        if (requestPermissions()) {
            if (cam == null) {
                cam = Camera.open();
            }
//
//            List<Camera.Size> picSizes =
//                    cam.getParameters().getSupportedPictureSizes();
//            List<Camera.Size> previewSizes =
//                    cam.getParameters().getSupportedPreviewSizes();
//            List<Camera.Size> videoSizes =
//                    cam.getParameters().getSupportedVideoSizes();
//            for (Camera.Size picSize : picSizes
//                    ) {
//                Log.d(TAG, "Picture : " + picSize.toString() + " " + picSize);
//            }
//            for (Camera.Size prevSize : previewSizes
//                    ) {
//                Log.d(TAG, "Preview : " + prevSize.width + " " + prevSize.height);
//            }
//            for (Camera.Size picSize : videoSizes
//                    ) {
//                Log.d(TAG, "Picture : " + picSize.width + " " + picSize.height);
//            }
//
//
            int rotaion = 0;
            switch (getWindowManager().getDefaultDisplay().getRotation()) {
                case Surface.ROTATION_0:
                    rotaion = 90;
                    break;
                case Surface.ROTATION_90:
                    rotaion = 0;
                    break;
                case Surface.ROTATION_270:
                    rotaion = 180;
                    break;
                case Surface.ROTATION_180:
                    rotaion = 270;
                    break;
            }
//            cam.getParameters().setRotation(90);
            cam.setDisplayOrientation(rotaion);
//
                Camera.Parameters parameters = cam.getParameters();
                parameters.setRotation(rotaion);
                cam.setParameters(parameters);
//
////        cam.getParameters().setPictureSize();
//
            cameraPreview.initialize(this, cam);

//            cameraPreview.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    takePicture();
//                }
//            });
//
////        CameraPreview cameraPreview = new CameraPreview(this, cam);
//            //      container.addView(cameraPreview);
//
//            if (container != null)
//                container.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        takePicture();
//                    }
//                });
//            capture.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    takePicture();
//
//                }
//            });

            video.setText("Start");
            video.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isRecording) {
                        mediaRecorder.stop();
                        releaseMediaRecorder();
                        cam.lock();
                        video.setText("Start");
                        isRecording = false;
                    } else {
                        if (prepareRecorder()) {
                            mediaRecorder.start();
                            video.setText("Stop");
                            isRecording = true;
                        } else {
                            releaseMediaRecorder();
                        }
                    }
                }
            });
        }
    }


    boolean prepareRecorder() {
        boolean returnValue = false;
        if (cam != null) {
            mediaRecorder = new MediaRecorder();

            cam.unlock();
            mediaRecorder.setCamera(cam);

            mediaRecorder.setAudioSource(MediaRecorder.AudioSource.CAMCORDER);
            mediaRecorder.setVideoSource(MediaRecorder.VideoSource.CAMERA);
            mediaRecorder.setPreviewDisplay
                    (cameraPreview.getHolder().getSurface());

            try {
                //mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);

                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
                mediaRecorder.setVideoEncoder(MediaRecorder.VideoEncoder.DEFAULT);

                File mediaFile = new File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES) + File.separator +
                        "VID_" + System.currentTimeMillis() + ".mp4");
                mediaRecorder.setOutputFile(mediaFile.getAbsolutePath());

                mediaRecorder.prepare();
                returnValue = true;
            } catch (Exception e) {
                e.printStackTrace();
                releaseMediaRecorder();
                returnValue = false;
            }
        }
        return returnValue;
    }

    void takePicture() {

        Camera.PictureCallback callback = new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                Log.d(TAG, "onPictureTaken: Size+" + data.length);
                File mediaFile = new File(Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_PICTURES) + File.separator +
                        "IMG_" + System.currentTimeMillis() + ".jpg");
                try {
                    FileOutputStream fos =
                            new FileOutputStream(mediaFile);
                    fos.write(data);
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                camera.stopPreview();
                camera.startPreview();
            }
        };
        cam.takePicture(null, null, callback);
    }

    private boolean requestPermissions() {
        if (ActivityCompat.
                checkSelfPermission
                        (this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED

                || ActivityCompat.
                checkSelfPermission
                        (this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED
                || ActivityCompat.
                checkSelfPermission
                        (this, Manifest.permission.RECORD_AUDIO)
                == PackageManager.PERMISSION_DENIED
                ) {
            ActivityCompat.
                    requestPermissions(this, new String[]{Manifest.permission.CAMERA,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                    Manifest.permission.RECORD_AUDIO},
                            requestCodeCamera);
            return false;
        }
        return true;
    }

    private void releaseMediaRecorder() {
        if (mediaRecorder != null) {
            mediaRecorder.reset();   // clear recorder configuration
            mediaRecorder.release(); // release the recorder object
            mediaRecorder = null;
            cam.lock();           // lock camera for later use
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == requestCodeCamera) {

        }
    }

    @Override
    protected void onPause() {
        if (cam != null)
            cam.release();
        releaseMediaRecorder();
        super.onPause();
    }
}
