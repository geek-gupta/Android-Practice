package com.example.gaurav.kidzoo.AlphabetList;

import android.content.Context;
import android.media.Image;
import android.media.MediaPlayer;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gaurav.kidzoo.AlphabetsListActivity;
import com.example.gaurav.kidzoo.ItemList.ItemModel;
import com.example.gaurav.kidzoo.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by gaurav on 8/20/2017.
 */

public class AlphabetListAdapter extends RecyclerView.Adapter<AlphabetListAdapter.ViewHolder> {
    MediaPlayer mp;
    Context context;
    ArrayList<AlphabetModel> alphabetModels;

    public AlphabetListAdapter(Context context, ArrayList<AlphabetModel> alphabetModels) {
        this.context = context;
        this.alphabetModels = alphabetModels;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.alphabet_list_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.textImage.setImageResource(alphabetModels.get(position).getTextImage());
        holder.iconImage.setImageResource(alphabetModels.get(position).getIconImage());
        holder.textData.setText(alphabetModels.get(position).getName());
        holder.layout_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        mp = MediaPlayer.create(context,R.raw.a);
                        mp.start();
                        break;
                    case 1:
                        mp = MediaPlayer.create(context,R.raw.b);
                        mp.start();
                        break;
                    case 2:
                        mp = MediaPlayer.create(context,R.raw.c);
                        mp.start();
                        break;
                    case 3:
                        mp = MediaPlayer.create(context,R.raw.d);
                        mp.start();
                        break;
                    case 4:
                        mp = MediaPlayer.create(context,R.raw.e);
                        mp.start();
                        break;
                    case 5:
                        mp = MediaPlayer.create(context,R.raw.f);
                        mp.start();

                        break;
                    case 6:
                        mp = MediaPlayer.create(context,R.raw.g);
                        mp.start();
                        break;
                    case 7:
                        mp = MediaPlayer.create(context,R.raw.h);
                        mp.start();
                        break;
                    case 8:
                        mp = MediaPlayer.create(context,R.raw.i);
                        mp.start();
                        break;
                    case 9:
                        mp = MediaPlayer.create(context,R.raw.j);
                        mp.start();
                        break;
                    case 10:
                        mp = MediaPlayer.create(context,R.raw.k);
                        mp.start();
                        break;
                    case 11:
                        mp = MediaPlayer.create(context,R.raw.l);
                        mp.start();
                        break;
                    case 12:
                        mp = MediaPlayer.create(context,R.raw.m);
                        mp.start();
                        break;
                    case 13:
                        mp = MediaPlayer.create(context,R.raw.n);
                        mp.start();
                        break;
                    case 14:
                        mp = MediaPlayer.create(context,R.raw.o);
                        mp.start();
                        break;
                    case 15:
                        mp = MediaPlayer.create(context,R.raw.p);
                        mp.start();
                        break;
                    case 16:
                        mp = MediaPlayer.create(context,R.raw.q);
                        mp.start();
                        break;
                    case 17:
                        mp = MediaPlayer.create(context,R.raw.r);
                        mp.start();
                        break;
                    case 18:
                        mp = MediaPlayer.create(context,R.raw.s);
                        mp.start();
                        break;
                    case 19:
                        mp = MediaPlayer.create(context,R.raw.t);
                        mp.start();
                        break;
                    case 20:
                        mp = MediaPlayer.create(context,R.raw.u);
                        mp.start();
                        break;
                    case 21:
                        mp = MediaPlayer.create(context,R.raw.v);
                        mp.start();
                        break;
                    case 22:
                        mp = MediaPlayer.create(context,R.raw.w);
                        mp.start();
                        break;
                    case 23:
                        mp = MediaPlayer.create(context,R.raw.x);
                        mp.start();
                        break;
                    case 24:
                        mp = MediaPlayer.create(context,R.raw.y);
                        mp.start();
                        break;
                    case 25:
                        mp = MediaPlayer.create(context,R.raw.z);
                        mp.start();
                        break;

                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return alphabetModels.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iconImage,textImage;
        LinearLayout layout_list;
        TextView textData;
        public ViewHolder(View itemView) {
            super(itemView);
            iconImage = (ImageView) itemView.findViewById(R.id.item_image_icon);
            textImage = (ImageView) itemView.findViewById(R.id.item_image_text);
            textData = (TextView) itemView.findViewById(R.id.text_data);
            layout_list = (LinearLayout) itemView.findViewById(R.id.layout_list);
        }
    }
}

