package com.example.gaurav.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by gaurav on 6/16/2017.
 */

public class BlueFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.layout_blue,null);

        Button btnfrag1 = (Button) fragView.findViewById(R.id.btnfrag1);

        btnfrag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setData(-1);
            }
        });
        return fragView;

    }
    public void setData(int a){

    }
}
