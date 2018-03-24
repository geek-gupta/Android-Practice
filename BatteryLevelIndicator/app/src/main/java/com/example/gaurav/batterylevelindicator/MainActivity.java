package com.example.gaurav.batterylevelindicator;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.os.BatteryManager.EXTRA_LEVEL;
import static android.os.BatteryManager.EXTRA_SCALE;

public class MainActivity extends AppCompatActivity {

    IntentFilter intentFilter;
    BroadcastReceiver receiver;
    TextView tvResult;
    ProgressBar batterlevel;
    String myBroadCast = "some.random.string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.txtView);
        batterlevel = (ProgressBar) findViewById(R.id.battery_progress);

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int level=-1,scale =100;
                if(intent.hasExtra(BatteryManager.EXTRA_LEVEL))
                    level = intent.getIntExtra(EXTRA_LEVEL,-1);
                if(intent.hasExtra(BatteryManager.EXTRA_SCALE))
                    scale = intent.getIntExtra(EXTRA_SCALE,100);
                tvResult.setText(String.valueOf(((float)level/scale)*100));
                int battery_level = (int)(((float)level/scale)*100);
                batterlevel.setProgress(battery_level);

            }
        };

        intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        Intent broadCastintent = new Intent();
        broadCastintent.setAction(myBroadCast);
        sendBroadcast(broadCastintent);
    }

    @Override
    protected void onPostResume() {

        super.onPostResume();
        registerReceiver(receiver,intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(receiver);
        super.onPause();
    }
}
