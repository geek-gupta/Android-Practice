package com.example.gaurav.listview2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/13/2017.
 */

public class MyAdapter extends BaseAdapter {
    String number_phone="+918512044327";
    Context context;
    ArrayList<Display> displays;


    public MyAdapter(Context context, ArrayList<Display> contacts){
        this.context=context;
        this.displays=contacts;
    }

    @Override
    public int getCount() {
        // Log.d(Tag,"InCount");
        return displays.size();

    }

    @Override
    public Display getItem(int position) {
        //Log.d(Tag,"InGetPosition");
        return displays.get(position);

    }

    @Override
    public long getItemId(int position) {
        //Log.d(Tag,"InGetItemId");
        return getItem(position).id;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Log.d(Tag,"InGetView");


        LayoutInflater inflator=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflator.inflate(R.layout.list,parent,false);

        final View a=convertView;
        final TextView t1=(TextView) convertView.findViewById(R.id.t1);
        Button btn1=(Button) convertView.findViewById(R.id.btn1);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t1.setText("Gaurav");
            }
        });

        return convertView;
    }
}
