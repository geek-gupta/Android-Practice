package com.example.gaurav.hypemessanger.MainUI;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaurav.hypemessanger.ChatPackage.ChatListActivity;
import com.example.gaurav.hypemessanger.CommonUtils.Constants;
import com.example.gaurav.hypemessanger.Model.UserModel;
import com.example.gaurav.hypemessanger.R;

import java.util.ArrayList;

/**
 * Created by gaurav on 8/29/2017.
 */

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    Context context;
    ArrayList<UserModel> users;

    public UserListAdapter(Context context, ArrayList<UserModel> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.user_list_item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        final UserModel user = users.get(i);
        viewHolder.userNameTv.setText(user.getName());
        viewHolder.userNameTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChatListActivity.class);
                intent.putExtra(Constants.USER_TOKEN_KEY,user.getToken());
                intent.putExtra(Constants.USER_EMAIL_KEY,user.getEmail());
                intent.putExtra(Constants.USER_NAME_KEY,user.getName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView userNameTv;

        public ViewHolder(View itemView) {
            super(itemView);
            userNameTv = (TextView) itemView.findViewById(
                    R.id.user_name);
        }
    }
}
