package com.example.gaurav.whatsapp.chats;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaurav.whatsapp.R;
import com.example.gaurav.whatsapp.model.ContactModel;
import com.example.gaurav.*;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gaurav on 6/23/2017.
 */

public class ChatsListAdapter extends RecyclerView.Adapter<ChatsListAdapter.ChatsViewHolder> {
    Context context;
    ArrayList<ContactModel> contactModels;

    public ChatsListAdapter(Context context, ArrayList<ContactModel> contactModels) {
        this.context = context;
        this.contactModels = contactModels;
    }

    @Override
    public ChatsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ((LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.list_item,parent,false);

        return new ChatsViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ChatsViewHolder holder, int position) {
        ContactModel contact = contactModels.get(position);
        holder.tvName.setText(contact.getName());
        holder.tvlatSeen.setText(contact.getLastseen());
        holder.tvrecentMessage.setText(contact.getRecent_messeage());
    }

    @Override
    public int getItemCount() {
        return contactModels.size();
    }

    class ChatsViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvlatSeen;
        TextView tvrecentMessage;
        public ChatsViewHolder(View itemView) {

            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvname);
            tvrecentMessage = (TextView) itemView.findViewById(R.id.tvmsg);
            tvlatSeen = (TextView) itemView.findViewById(R.id.tvseen);
        }
    }
}
