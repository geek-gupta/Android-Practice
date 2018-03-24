package com.example.gaurav.kidzoo.ItemList;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gaurav.kidzoo.AlphabetsListActivity;
import com.example.gaurav.kidzoo.R;

import java.util.ArrayList;

/**
 * Created by gaurav on 8/20/2017.
 */

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ViewHolder> {

    Context context;
    ArrayList<ItemModel> itemModels;

    public ItemListAdapter(Context context, ArrayList<ItemModel> itemModels) {
        this.context = context;
        this.itemModels = itemModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_item_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.itemText.setText(itemModels.get(position).getName());
        holder.itemImage.setImageResource(itemModels.get(position).getImgsrc());
        holder.listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Intent alphabetsIntent = new Intent(context, AlphabetsListActivity.class);
                        context.startActivity(alphabetsIntent);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemModels.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView itemText;
        ImageView itemImage;
        LinearLayout listItem;

        public ViewHolder(View itemView) {
            super(itemView);
            itemText = (TextView) itemView.findViewById(R.id.item_text);
            itemImage = (ImageView) itemView.findViewById(R.id.item_image);
            listItem = (LinearLayout) itemView.findViewById(R.id.layout_list);

        }
    }
}
