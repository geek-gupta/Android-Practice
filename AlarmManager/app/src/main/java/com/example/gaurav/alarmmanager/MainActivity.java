package com.example.gaurav.alarmmanager;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int PENDING_INTENT_ID = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        PendingIntent pi = PendingIntent.getActivities(this,PENDING_INTENT_ID,
                new Intent[]{new Intent(this,Main2Activity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)},0);
        am.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime()+ 6000,pi);
        //am.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+6000,5000,pi);

    }
}
