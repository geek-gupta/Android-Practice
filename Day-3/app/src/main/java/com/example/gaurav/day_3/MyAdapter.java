package com.example.gaurav.day_3;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/9/2017.
 */

public class MyAdapter extends BaseAdapter {
   Context context;
    ArrayList<Contacts> contacts;
    String Tag="InAdapter";


   public MyAdapter(Context context, ArrayList<Contacts> contacts){
       this.context=context;
       this.contacts=contacts;
   }

    @Override
    public int getCount() {
        Log.d(Tag,"InCount");
        return contacts.size();

    }

    @Override
    public Contacts getItem(int position) {
        Log.d(Tag,"InGetPosition");
        return contacts.get(position);

    }

    @Override
    public long getItemId(int position) {
        Log.d(Tag,"InGetItemId");
        return getItem(position).id;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Log.d(Tag,"InGetView");

        LayoutInflater inflator=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflator.inflate(R.layout.list_txt,parent,false);
        final View a=convertView;
        TextView tvname=(TextView) convertView.findViewById(R.id.tvName);
        ImageView tvImg=(ImageView) convertView.findViewById(R.id.tvImg);

        tvImg.setImageDrawable(context.getResources().getDrawable(getItem(position).id));
        tvname.setText(getItem(position).name);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contacts.get(position).name="Gaurav";
                notifyDataSetChanged();
                a.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
                Toast.makeText(context,getItem(position).name, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
