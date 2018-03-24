package com.example.gaurav.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by gaurav on 6/16/2017.
 */

public class RedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.layout_red,null);

        Button btnred = (Button) fragView.findViewById(R.id.btnfrag2);
        //final TextView t1red = (TextView) fragView.findViewById(R.id.t1red);
        btnred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setData(1);
            }
        });
        return fragView;
    }
}
