package com.example.gaurav.facteria.SplashFragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurav.facteria.R;

/**
 * Created by gaurav on 6/24/2017.
 */

public class FourthSplashScreen extends Fragment {
    int item;

    public FourthSplashScreen(){}
    @SuppressLint("ValidFragment")
    public FourthSplashScreen(int position){item=position;}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fourth_screen_splash,null);
        return  view;
    }
}
