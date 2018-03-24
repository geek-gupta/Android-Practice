package com.example.gaurav.foodiee;

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

import com.google.android.gms.maps.OnMapReadyCallback;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/10/2017.
 */

public class MyAdapter extends BaseAdapter {

    final Context context;
    ArrayList<Restro> restros;


    public MyAdapter(Context context, ArrayList<Restro> restros) {
        this.context = context;
        this.restros = restros;
    }

    @Override
    public int getCount() {
        return restros.size();

    }

    @Override
    public Restro getItem(int position) {
        return restros.get(position);

    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final LayoutInflater inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflator.inflate(R.layout.list_item, parent, false);

        final View a = convertView;

        ImageView Img = (ImageView) convertView.findViewById(R.id.logo);
        TextView name = (TextView) convertView.findViewById(R.id.nameField);
        final TextView number = (TextView) convertView.findViewById(R.id.detailfield);
        ImageButton imgbtn = (ImageButton) convertView.findViewById(R.id.map);


        Img.setImageDrawable(context.getResources().getDrawable(getItem(position).id));
        name.setText(getItem(position).name);
        number.setText(getItem(position).detail);

        if (getItem(position).isSelected) {
            a.setBackgroundColor(context.getResources().getColor(R.color.colorLightVoilet));
        }

        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                try {
                    intent = new Intent(context, MapsActivity.class);
                    context.startActivity(intent);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }
        });


        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a.setBackgroundColor(context.getResources().getColor(R.color.colorLightVoilet));
                for (Restro contact : restros) {
                    contact.isSelected = false;
                }
                getItem(position).isSelected = !getItem(position).isSelected;
                notifyDataSetChanged();
            }
        });


        return convertView;
    }

}