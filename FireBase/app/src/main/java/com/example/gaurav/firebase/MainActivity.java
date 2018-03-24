package com.example.gaurav.firebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    public FirebaseAnalytics analytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        analytics = FirebaseAnalytics.getInstance(this);
        Bundle msgBundle = new Bundle();
        msgBundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
        msgBundle.putString(FirebaseAnalytics.Param.VALUE, "Value");
        analytics.logEvent(FirebaseAnalytics.Event.APP_OPEN, msgBundle);
        FirebaseMessaging.getInstance().subscribeToTopic("News");
    }
}
