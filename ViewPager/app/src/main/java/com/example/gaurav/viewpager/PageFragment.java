package com.example.gaurav.viewpager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by gaurav on 6/20/2017.
 */

public class PageFragment extends Fragment {
    int item;

    @SuppressLint("ValidFragment")
    public PageFragment(int position) {
        item=position;
    }
    public PageFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_view,null);
        return view;

    }
}
