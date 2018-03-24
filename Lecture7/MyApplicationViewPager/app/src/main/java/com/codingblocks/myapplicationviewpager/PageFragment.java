package com.codingblocks.myapplicationviewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nipun on 6/20/17.
 */


public class PageFragment extends Fragment {
    int item;

    public PageFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        TextView tv = (TextView) view.findViewById(R.id.txtView);
        int id = getArguments().getInt("id");
        tv.setText(String.valueOf(id));
        return view;
    }
}
