package com.company.gaurav.apkextractor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutSectionActivity extends AppCompatActivity {

    private TextView aboutSection,backUpText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_section);


        getSupportActionBar().setTitle("About");
        aboutSection = (TextView) findViewById(R.id.aboutSection);
        backUpText = (TextView) findViewById(R.id.app_backup_text);

        aboutSection.setText(R.string.about_section_text);
        backUpText.setText(R.string.back_up_text);
    }

}
