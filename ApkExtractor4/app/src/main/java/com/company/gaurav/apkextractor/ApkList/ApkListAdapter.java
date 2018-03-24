package com.company.gaurav.apkextractor.ApkList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.company.gaurav.apkextractor.R;

import java.util.ArrayList;

/**
 * Created by gaurav on 9/17/2017.
 */

public class ApkListAdapter extends RecyclerView.Adapter<ApkListAdapter.APKViewHolder>implements Filterable {

    private Context context;
    private ArrayList<ApkListModel> apkListModels;
    private OnItemClickListener ocl;
    private ArrayList<ApkListModel> mFilteredList;



    public ApkListAdapter(Context context, ArrayList<ApkListModel> apkListModels, OnItemClickListener ocl) {
        this.context = context;
        this.apkListModels = apkListModels;
        mFilteredList = apkListModels;
        this.ocl = ocl;
    }


    @Override


    public APKViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.apk_list_item, parent, false);
        return new APKViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final APKViewHolder holder, final int position) {

        final ApkListModel model = apkListModels.get(position);
        holder.tvname.setText(model.getName());
        holder.imgIcon.setImageDrawable(model.getIconPath());
        holder.onItemClickListener = ocl;
        holder.tvname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.onItemClickListener.onItemClick(position, model);
            }
        });
        holder.imgIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.onItemClickListener.onItemClick(position, model);
            }
        });

    }

    @Override
    public int getItemCount() {
        if (mFilteredList == null)
            return 0;

        return mFilteredList.size();
    }

    public interface OnItemClickListener {
        public void onItemClick(int position, ApkListModel model);

    }
    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString().toLowerCase().trim();

                //charString = charString.toLowerCase();
                if (charString.isEmpty()) {

                    mFilteredList = apkListModels;
                } else {

                    ArrayList<ApkListModel> filteredList = new ArrayList<>();

                    for (ApkListModel apkListModel : apkListModels) {

                        if (apkListModel.getName().toLowerCase().startsWith(charString) ){

                            filteredList.add(apkListModel);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (ArrayList<ApkListModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public static class APKViewHolder extends RecyclerView.ViewHolder {

        TextView tvname;
        ImageView imgIcon;
        OnItemClickListener onItemClickListener;

        public APKViewHolder(View itemView) {
            super(itemView);
            tvname = (TextView) itemView.findViewById(R.id.app_name);
            imgIcon = (ImageView) itemView.findViewById(R.id.app_icon_img);

            //onItemClickListener = ocl;
        }
    }
}
