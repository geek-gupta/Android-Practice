package com.example.gaurav.vision.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.*;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurav.vision.R;

/**
 * Created by gaurav on 7/9/2017.
 */

public class Page_two_Fragment extends Fragment {
    int item;

    @SuppressLint("ValidFragment")
    public Page_two_Fragment(int position) {
        item=position;
    }
    public Page_two_Fragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.layout_two_viewpager,null);
        return view;
    }
}
