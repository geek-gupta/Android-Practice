package com.example.gaurav.mytimetable.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaurav.mytimetable.DayModel.MondayModel;
import com.example.gaurav.mytimetable.R;

import java.util.ArrayList;

/**
 * Created by gaurav on 8/14/2017.
 */

public class MonDayAdapter extends RecyclerView.Adapter<MonDayAdapter.ViewHolder> {
    Context context;
    ArrayList<MondayModel> mondayModels;

    public MonDayAdapter(Context context, ArrayList<MondayModel> mondayModels) {
        this.context = context;
        this.mondayModels = mondayModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.monday_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.work_text.setText(mondayModels.get(position).getWork());
        holder.time_text.setText(mondayModels.get(position).getStartTime()+"-"+mondayModels.get(position).getEndTime());
    }

    @Override
    public int getItemCount() {
        return mondayModels.size();
    }

    static class ViewHolder extends MainAdapter.ViewHolder{

        TextView work_text,time_text;
        public ViewHolder(View itemView) {
            super(itemView);
            work_text = (TextView) itemView.findViewById(R.id.work_text);
            time_text = (TextView) itemView.findViewById(R.id.time_text);
        }
    }
}
