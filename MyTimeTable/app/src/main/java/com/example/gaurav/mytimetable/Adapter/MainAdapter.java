package com.example.gaurav.mytimetable.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaurav.mytimetable.DayModel.DaysModel;
import com.example.gaurav.mytimetable.DayActivity.FridayActivity;
import com.example.gaurav.mytimetable.DayActivity.MondayActivity;
import com.example.gaurav.mytimetable.R;
import com.example.gaurav.mytimetable.DayActivity.SaturdayActivity;
import com.example.gaurav.mytimetable.DayActivity.SundayActivity;
import com.example.gaurav.mytimetable.DayActivity.ThursdayActivity;
import com.example.gaurav.mytimetable.DayActivity.TuesdayActivity;
import com.example.gaurav.mytimetable.DayActivity.WednesdayActivity;

import java.util.ArrayList;

/**
 * Created by gaurav on 8/14/2017.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    ArrayList<DaysModel> daysModel;

    public MainAdapter(Context context, ArrayList<DaysModel> daysModel) {
        this.context = context;
        this.daysModel = daysModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.days_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.daysList.setText(daysModel.get(position).getName());
        holder.daysList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent mondayIntent = new Intent(context,MondayActivity.class);
                        context.startActivity(mondayIntent);
                        break;
                    case 1:
                        Intent tuesdayIntent = new Intent(context,TuesdayActivity.class);
                        context.startActivity(tuesdayIntent);
                        break;
                    case 2:
                        Intent wednesdayIntent = new Intent(context,WednesdayActivity.class);
                        context.startActivity(wednesdayIntent);
                        break;
                    case 3:
                        Intent thursdayIntent = new Intent(context,ThursdayActivity.class);
                        context.startActivity(thursdayIntent);
                        break;
                    case 4:
                        Intent fridayIntent = new Intent(context,FridayActivity.class);
                        context.startActivity(fridayIntent);
                        break;
                    case 5:
                        Intent saturdayIntent = new Intent(context,SaturdayActivity.class);
                        context.startActivity(saturdayIntent);
                        break;
                    case 6:
                        Intent sundayIntent = new Intent(context,SundayActivity.class);
                        context.startActivity(sundayIntent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return daysModel.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView daysList;

        public ViewHolder(View itemView) {
            super(itemView);
            daysList = (TextView) itemView.findViewById(R.id.dayList);
        }
    }
}
