package com.example.gaurav.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService1 extends Service {
    String TAG = "INSERVICEXYZ";

    public MyService1() {
        Log.d(TAG, "In Constructor");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "In OnBind");
        // TODO: Return the communication channel to the service.
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "In OnStartCommand");
        printTimeLog(10);
        return START_STICKY;
    }

    void printTimeLog(int duration) {
        for (int i = 0; i < duration; i++) {
            loopOneSecond();
            Log.w(TAG, "PrintTimeLog:" + i);
        }
    }

    void loopOneSecond() {
        long currentTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - currentTime < 1000) {
        }
    }
}
