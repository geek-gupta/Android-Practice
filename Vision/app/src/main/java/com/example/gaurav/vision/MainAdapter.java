package com.example.gaurav.vision;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gaurav on 7/11/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemHolder> {

    Context context;
    ArrayList<MainModel> models;

    public MainAdapter(Context context, ArrayList<MainModel> models) {
        this.context = context;
        this.models = models;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv1_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, final int position) {

        holder.name.setText(models.get(position).getName());
        holder.relativeLayout.setBackgroundColor(Color.WHITE);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (position) {
                    case 0:
                        Intent intent = new Intent(context, Garbage_cleaning_activity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context,Girls_safety_Activity.class);
                        context.startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(context,Old_Age_Home_Activity.class);
                        context.startActivity(intent2);
                        break;
                    }

            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class ItemHolder extends RecyclerView.ViewHolder {

        TextView name;
        RelativeLayout relativeLayout;

        public ItemHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameView);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relative_white_background);
        }
    }
}
