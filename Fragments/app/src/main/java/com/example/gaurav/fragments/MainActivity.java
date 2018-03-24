package com.example.gaurav.fragments;

import android.os.PersistableBundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    FrameLayout frame;
    String KEY="FRAGKEY";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY,((ResultFragment)getSupportFragmentManager().findFragmentById(R.id.fragment3)).sendData());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity2);
        frame = (FrameLayout) findViewById(R.id.frame);
        Button btnchange = (Button) findViewById(R.id.buttonred);
        Button btnchange2 = (Button) findViewById(R.id.btnblue);
        final RedFragment rf = new RedFragment();
        final BlueFragment bf = new BlueFragment();
        /*btnchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.frame, rf);
                ft.commit();
            }
        });

        btnchange2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlueFragment bf2=new BlueFragment();
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.frame, bf2);
                ft.commit();
            }
        });*/


        getSupportFragmentManager().findFragmentById(R.id.fragment2);
        getSupportFragmentManager().findFragmentById(R.id.fragment);
        getSupportFragmentManager().findFragmentById(R.id.fragment3);
        if(savedInstanceState!=null){
        String data=savedInstanceState.getString(KEY);

        setData(Integer.parseInt(data));}
    }

    public void setData(int data) {

        ((ResultFragment) getSupportFragmentManager().findFragmentById(R.id.fragment3)).getData(data);

    }

}
