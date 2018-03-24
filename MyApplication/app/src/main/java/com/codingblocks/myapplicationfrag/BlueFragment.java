package com.codingblocks.myapplicationfrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Nipun on 6/16/17.
 */

public class BlueFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.layout_blue,null);
        Button btn= (Button)fragView.findViewById(R.id.btnfrag1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                ((MainActivity)getActivity()).showMessage();
                ((MainActivity)getActivity()).changeVal(-1);

               // Toast.makeText(getActivity(), "From Blue", Toast.LENGTH_SHORT).show();
            }
        });
        return fragView;
    }
}
