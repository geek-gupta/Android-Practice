package com.example.gaurav.imdb_rating;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by gaurav on 7/18/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> implements Filterable {

    Context context;
    ArrayList<IMDbModel> imDbModels;
    ArrayList<IMDbModel> masterList;

    public ListAdapter(Context context, ArrayList<IMDbModel> imDbModels) {
        this.context = context;
        this.imDbModels = imDbModels;
        this.masterList = imDbModels;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listitem,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {

        holder.movieName.setText(imDbModels.get(position).getTitle());
        holder.movieRating.setText(imDbModels.get(position).getId());
    }

    @Override
    public int getItemCount() {
        if(imDbModels != null) {
            return imDbModels.size();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Myfilter();
    }

    static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView movieName,movieRating;
        public ListViewHolder(View itemView) {
            super(itemView);
            movieName = (TextView) itemView.findViewById(R.id.movieName);
            movieRating = (TextView) itemView.findViewById(R.id.movieRating);
        }
    }
    public void update(ArrayList<IMDbModel> imDbModels){
        this.imDbModels=imDbModels;
        this.masterList = imDbModels;
        notifyDataSetChanged();
    }
    class Myfilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if(constraint != null && constraint.length()>0){
                ArrayList<IMDbModel> searchResults = new ArrayList<>();
                for(IMDbModel movie : masterList){
                    if(movie.getTitle().toLowerCase().contains(constraint.toString().toLowerCase().trim())){
                            searchResults.add(movie);
                        }
                }
                filterResults.values = searchResults;
            }else
                filterResults.values = masterList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            if(results != null){
                imDbModels = (ArrayList<IMDbModel>) results.values;
                notifyDataSetChanged();
            }
        }
    }
}
