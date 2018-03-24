package com.example.gaurav.hypemessanger.ChatPackage;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaurav.hypemessanger.Model.ChatModel;
import com.example.gaurav.hypemessanger.R;

import java.util.ArrayList;

/**
 * Created by gaurav on 8/29/2017.
 */

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {

    Context context;
    ArrayList<ChatModel> chats;

    public ChatListAdapter(Context context, ArrayList<ChatModel> chats) {
        this.context = context;
        this.chats = chats;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup view, int viewType) {
//
        View viewHolder = null;
        if (viewType == 0) {
            viewHolder = LayoutInflater.from(context).inflate(R.layout.chat_msg_recieved_view, view, false);
        } else {
            viewHolder = LayoutInflater.from(context).inflate(R.layout.chat_msg_send_view, view, false);
        }
//
//       View viewHolder = LayoutInflater.from(context).inflate(R.layout.chat_msg_send_view, view, false);
        return new ViewHolder(viewHolder);
    }

    @Override
    public int getItemViewType(int position) {
       // return super.getItemViewType(position);
        if(chats.get(position).getMessageType() == 0){
            return 0;
        }
        else {
            return 1;
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

//        if(chats.get(position).getMessageType() == 0){
//            viewHolder.msg.setGravity(Gravity.LEFT);
//
//        }
//        else {
//            viewHolder.msg.setBackgroundColor(Color.BLUE);
//            viewHolder.msg.setGravity(Gravity.RIGHT);
//        }
        viewHolder.msg.setText(chats.get(position).getChatMessage());


    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView msg;


        public ViewHolder(View itemView) {
            super(itemView);
            msg = (TextView) itemView.findViewById(R.id.msg);
        }
    }
}
