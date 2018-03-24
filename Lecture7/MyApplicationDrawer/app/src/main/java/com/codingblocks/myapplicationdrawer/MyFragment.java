package com.codingblocks.myapplicationdrawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Nipun on 6/20/17.
 */

public class MyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentview, container, false);
        TextView tv = ((TextView) view.findViewById(R.id.tv1));
        if (getArguments() != null)
            tv.setText(String.valueOf(getArguments().getInt("id", 0)));
        Button btn = (Button) view.findViewById(R.id.btnClick);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).opendrawer();
            }
        });
        Button btn2 = (Button) view.findViewById(R.id.btnCloseClick);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).closedrawer();
            }
        });
        return view;
    }
}
