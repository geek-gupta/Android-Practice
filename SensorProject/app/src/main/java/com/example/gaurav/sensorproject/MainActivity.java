package com.example.gaurav.sensorproject;

import android.app.admin.DevicePolicyManager;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivitySensor";
    SensorManager sensorManager;
    List<Sensor> sensors;
    SensorEventListener sensorEventListener;
    Sensor accelerometerSensor,proximitySensor;
    LinearLayout parentLayout;
    TextView txtView;
    DevicePolicyManager mDPM ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parentLayout = (LinearLayout) findViewById(R.id.parentlayout);
        txtView = (TextView) findViewById(R.id.txtView);
         sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
         sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(Sensor sensor : sensors){


            Log.d(TAG,"name :"+sensor.getName());

            Log.d(TAG,"Type : "+sensor.getStringType());

            Log.d(TAG,"------------------");
        }
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

                    Log.d(TAG, "OnSensorChanged : " + event.values[0]);

                } else if (event.sensor.getType() == Sensor.TYPE_PROXIMITY){

                    if(event.values[0]<1){
                        // vibration for 200 milliseconds
                        ((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(200);
                        parentLayout.setBackgroundColor(Color.CYAN);
                        txtView.setText("Hii I m gaurav");
                        mDPM.lockNow();
                    }else
                        parentLayout.setBackgroundColor(0x00FF00);
                        txtView.setText("Hii i m reverted");

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        sensorManager.registerListener(sensorEventListener,accelerometerSensor,1000*1000,1000);
        sensorManager.registerListener(sensorEventListener,proximitySensor,1000*1000,1000);
    }

    @Override
    protected void onPause() {
        sensorManager.unregisterListener(sensorEventListener);
        super.onPause();
    }
}
