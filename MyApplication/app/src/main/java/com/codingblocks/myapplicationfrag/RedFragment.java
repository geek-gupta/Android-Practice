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

public class RedFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View frag2= inflater.inflate(R.layout.layout_red,null);
        Button btn= (Button)frag2.findViewById(R.id.btnfrag2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // MainActivity.showMessage(getActivity());
                ((MainActivity)getActivity()).changeVal(1);
              //  Toast.makeText(getActivity(), "From Red", Toast.LENGTH_SHORT).show();
            }
        });
        return frag2;
    }
}
