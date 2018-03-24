package com.example.gaurav.vision;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;

import com.google.android.gms.maps.MapView;

public class Old_Age_Home_Activity extends AppCompatActivity implements View.OnClickListener {

    SearchView oldAgeHomeSearch;
    ActionBar actionBar;
    MapView oldAgeMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old__age__home_);
        actionBar = getSupportActionBar();
        actionBar.setTitle("Old Age Home");
        oldAgeHomeSearch = (SearchView) findViewById(R.id.searcOldAgeHome);
        oldAgeMap = (MapView) findViewById(R.id.oldagemap);
        oldAgeHomeSearch.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.searcOldAgeHome:

        }
    }
}
