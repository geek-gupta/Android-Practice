package com.codingblocks.myapplicationfrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Nipun on 6/16/17.
 */

public class ResultFragment extends Fragment {
TextView tvResult;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view3=inflater.inflate(R.layout.result_fragment,container,false);
        tvResult = (TextView) view3.findViewById(R.id.textView);

        return view3;
    }

    public void changeVal(int val)
    {
        if(tvResult==null)
            return;

            int currentVal=0;
        try{
            if(!tvResult.getText().toString().isEmpty())
                currentVal= Integer.valueOf(tvResult.getText().toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        tvResult.setText(String.valueOf(currentVal + val));

    }

}
