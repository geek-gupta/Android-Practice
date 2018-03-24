package com.codingblocks.whatsapp.Status;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.model.StatusModel;

import java.util.ArrayList;

/**
 * Created by Nipun on 6/23/17.
 */

public class StatusListAdapter extends
        RecyclerView.Adapter<StatusListAdapter.StatusViewHolder> {

    ArrayList<StatusModel> statuses;
    Context context;

    StatusListAdapter(ArrayList<StatusModel> statuses, Context context) {
        this.statuses = statuses;
        this.context = context;
    }


    @Override
    public StatusListAdapter.StatusViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View itemView = ((LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
                    inflate(R.layout.chat_item, parent, false);
            return new StatusListAdapter.StatusViewHolder(itemView);
        } else {
            View itemView = ((LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE)).
                    inflate(R.layout.list_header_layout, parent, false);
            return new StatusListAdapter.StatusViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(StatusListAdapter.StatusViewHolder holder, int position) {
        StatusModel status = statuses.get(position);
        if (holder.tvHeader != null)
            holder.tvHeader.setText(status.getName());
        else {
            holder.tvName.setText(status.getName());
            holder.tvLastSeen.setText(status.getLastSeen());
            holder.tvRecentMessage.setText(status.getLastSeen());
        }
    }

    @Override
    public int getItemViewType(int position) {
        StatusModel statusModel = statuses.get(position);
        if (statusModel.isHeading())
            return 0;
        else
            return 1;
    }


    @Override
    public int getItemCount() {
        return statuses.size();
    }

    class StatusViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvLastSeen;
        TextView tvRecentMessage;
        TextView tvHeader;

        public StatusViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvLastSeen = (TextView) itemView.findViewById(R.id.tvLastSeen);
            tvRecentMessage = (TextView) itemView.findViewById(R.id.tvRecentMessage);
            tvHeader = (TextView) itemView.findViewById(R.id.headerTV);
        }
    }
}
