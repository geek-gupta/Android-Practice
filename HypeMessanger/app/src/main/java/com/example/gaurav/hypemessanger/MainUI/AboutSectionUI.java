package com.example.gaurav.hypemessanger.MainUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.gaurav.hypemessanger.R;

public class AboutSectionUI extends AppCompatActivity {

    TextView titleMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_section_ui);


        getSupportActionBar().hide();

        titleMsg = (TextView) findViewById(R.id.titleMsg);

        //titleMsg.setBackgroundColor(Color.CYAN);
    }
}
