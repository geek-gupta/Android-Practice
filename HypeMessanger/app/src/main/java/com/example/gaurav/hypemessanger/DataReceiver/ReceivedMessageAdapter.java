package com.example.gaurav.hypemessanger.DataReceiver;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gaurav.hypemessanger.Model.MessageModel;
import com.example.gaurav.hypemessanger.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gaurav on 7/30/2017.
 */


public class ReceivedMessageAdapter extends RecyclerView.Adapter<ReceivedMessageAdapter.ViewHolder> {

    Context context;
    ArrayList<MessageModel> messageModels;

    public ReceivedMessageAdapter(Context context, ArrayList<MessageModel> messageModels) {
        this.context = context;
        this.messageModels = messageModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sender_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
           MessageModel messageModel = messageModels.get(position);
        holder.tvMsg.setText(messageModel.getData());
        holder.tvsendername.setText(messageModel.getSenderName());
    }

    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvMsg,tvsendername;

        public ViewHolder(View itemView) {
            super(itemView);
            tvMsg = (TextView) itemView.findViewById(R.id.sendToName);
            tvsendername = (TextView) itemView.findViewById(R.id.text_sender_name);
        }
    }

}
