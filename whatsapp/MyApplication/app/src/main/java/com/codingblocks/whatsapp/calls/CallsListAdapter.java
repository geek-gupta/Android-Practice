package com.codingblocks.whatsapp.calls;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.whatsapp.Chats.ChatsListAdapter;
import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.model.CallsModel;
import com.codingblocks.whatsapp.model.ChatModel;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/24/2017.
 */

public class CallsListAdapter  extends RecyclerView.Adapter<CallsListAdapter.callsViewHolder>{

    ArrayList<CallsModel> contacts;
    Context context;

    CallsListAdapter(ArrayList<CallsModel> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;
    }
    @Override
    public callsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = ((LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
                inflate(R.layout.calls_list_item, parent, false);
        return new callsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(callsViewHolder holder, int position) {
        CallsModel contact = contacts.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvRecentMessage.setText(contact.getRecentCallStatus());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class callsViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvLastSeen;
        TextView tvRecentMessage;

        public callsViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvRecentMessage = (TextView) itemView.findViewById(R.id.tvRecentMessage);
        }
    }
}
