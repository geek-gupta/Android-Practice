package com.codingblocks.cameraapp;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.security.Policy;

/**
 * Created by Nipun on 7/21/17.
 */

public class CameraPreview extends SurfaceView {

    Camera camera;
    SurfaceHolder holder;
    boolean isInitializd = false;

    public CameraPreview(Context context) {
        super(context);
    }

    public CameraPreview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CameraPreview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void initialize(Context context, final Camera camera) {
        if (isInitializd)
            return;

        isInitializd = true;

        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (holder.getSurface() == null)
                    return;
                try {
                    camera.setPreviewDisplay(holder);
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                if (holder.getSurface() == null)
                    return;
                camera.stopPreview();
//                camera.setDisplayOrientation(90);
//
//                Camera.Parameters parameters = camera.getParameters();
//                parameters.setRotation(90);
//                camera.setParameters(parameters);

                try {
                    camera.setPreviewDisplay(holder);
                    camera.startPreview();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }

    CameraPreview(Context context, final Camera camera) {
        super(context);
        this.camera = camera;
        initialize(context, camera);
    }
}
