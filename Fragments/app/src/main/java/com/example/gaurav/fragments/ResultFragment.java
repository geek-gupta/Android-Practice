package com.example.gaurav.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gaurav on 6/16/2017.
 */

public class ResultFragment extends Fragment {
    TextView txt;int n=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.result_frag,container,false);
        txt=(TextView) fragView.findViewById(R.id.t1green);
        return fragView;
    }
    public  void getData(int data){
        Integer current =0;
        if(!txt.getText().toString().isEmpty())
        current = Integer.parseInt(txt.getText().toString());
        int change  = data;
        txt.setText(String.valueOf(current + change));
    }
    public  String sendData(){
        return txt.getText().toString();
    }
}
