package com.codingblocks.whatsapp.Chats;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingblocks.whatsapp.R;


import com.codingblocks.whatsapp.model.ChatModel;

import java.util.ArrayList;

/**
 * Created by Nipun on 6/23/17.
 */

public class ChatsListAdapter extends
        RecyclerView.Adapter<ChatsListAdapter.ChatsViewHolder> {

    ArrayList<ChatModel> contacts;
    Context context;

    ChatsListAdapter(ArrayList<ChatModel> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }


    @Override
    public ChatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = ((LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
                inflate(R.layout.chat_item, parent, false);
        return new ChatsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatsViewHolder holder, int position) {
        ChatModel contact = contacts.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvLastSeen.setText(contact.getLastSeen());
        holder.tvRecentMessage.setText(contact.getRecentMessage());
        holder.tvImage.setImageResource(contact.getImageId());
    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ChatsViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvLastSeen;
        TextView tvRecentMessage;
        ImageView tvImage;

        public ChatsViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvLastSeen = (TextView) itemView.findViewById(R.id.tvLastSeen);
            tvRecentMessage = (TextView) itemView.findViewById(R.id.tvRecentMessage);
            tvImage = (ImageView) itemView.findViewById(R.id.chat_image);

        }
    }
}
