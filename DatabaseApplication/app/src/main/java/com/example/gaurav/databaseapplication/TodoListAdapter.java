package com.example.gaurav.databaseapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gaurav on 7/6/2017.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>{
    Context context;
    ArrayList<TodoModel> models;
    public TodoListAdapter(Context context,ArrayList<TodoModel> model) {

        this.context=context;
        this.models=model;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {


        holder.txtView.setText(models.get(position).getTask());
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static  class TodoViewHolder extends ViewHolder {
        TextView txtView;
        public TodoViewHolder(View itemView) {
            super(itemView);
            txtView = (TextView) itemView.findViewById(R.id.textView);
        }
    }
}