package com.codingblocks.myapplication13;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.myapplication13.models.TodoModel;

import java.util.ArrayList;

/**
 * Created by Nipun on 7/6/17.
 */

public class TodoListAdapter extends RecyclerView.Adapter
        <TodoListAdapter.TodoViewHolder> {
    ArrayList<TodoModel> todos;
    Context context;

    TodoListAdapter(Context context, ArrayList<TodoModel> todos) {
        this.context = context;
        this.todos = todos;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View listItemView =
                LayoutInflater.
                        from(context).inflate(R.layout.todo_list_item, parent, false);
        return new TodoViewHolder(listItemView);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        holder.tvItem.setText(todos.get(position).getTask());
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView tvItem;

        public TodoViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.todo_item_tv);
        }
    }
}
