package com.example.gaurav.contacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/15/2017.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Contacts> contacts;


    public MyAdapter(Context context, ArrayList<Contacts> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public int getCount() {
        // Log.d(Tag,"InCount");
        return contacts.size();

    }

    @Override
    public Contacts getItem(int position) {
        //Log.d(Tag,"InGetPosition");
        return contacts.get(position);

    }

    @Override
    public long getItemId(int position) {
        //Log.d(Tag,"InGetItemId");
        return getItem(position).id;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        //Log.d(Tag,"InGetView");
        Log.d("CovertView", String.valueOf(convertView));

        LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflator.inflate(R.layout.list_tem, parent, false);

        final View a = convertView;

        ImageView Img = (ImageView) convertView.findViewById(R.id.imageView);
        TextView name = (TextView) convertView.findViewById(R.id.textView);
        final TextView number = (TextView) convertView.findViewById(R.id.textView1);
        ImageButton imgbtn = (ImageButton) convertView.findViewById(R.id.imageButton);


        Img.setImageDrawable(context.getResources().getDrawable(getItem(position).id));
        name.setText(getItem(position).name);
        number.setText(getItem(position).number);

        if (getItem(position).isSelected) {
            a.setBackgroundColor(context.getResources().getColor(R.color.colorPinkLight));
        }

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacts x=getItem(position);
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel",getItem(position).number, null));
                try {
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.d("Exception", "Intent Exception" + e);
                }
            }
        });


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setBackgroundColor(context.getResources().getColor(R.color.colorPinkLight));
                for (Contacts contact : contacts) {
                    contact.isSelected = false;
                }
                getItem(position).isSelected = !getItem(position).isSelected;
                notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
