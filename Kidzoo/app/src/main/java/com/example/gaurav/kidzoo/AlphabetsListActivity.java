package com.example.gaurav.kidzoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaurav.kidzoo.AlphabetList.AlphabetListAdapter;
import com.example.gaurav.kidzoo.AlphabetList.AlphabetModel;
import com.example.gaurav.kidzoo.ItemList.ItemListAdapter;
import com.example.gaurav.kidzoo.ItemList.ItemModel;

import java.util.ArrayList;

public class AlphabetsListActivity extends AppCompatActivity {

    ArrayList<AlphabetModel> alphabetModels;
    RecyclerView mainRv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets_list);
        mainRv1 = (RecyclerView) findViewById(R.id.item_list);
        alphabetModels = new ArrayList<>();


        alphabetModels.add(new AlphabetModel("Apple",R.drawable.a,R.drawable.apple));
        alphabetModels.add(new AlphabetModel("Ball",R.drawable.b,R.drawable.ball));
        alphabetModels.add(new AlphabetModel("Cat",R.drawable.c,R.drawable.cat));
        alphabetModels.add(new AlphabetModel("Dog",R.drawable.d,R.drawable.dog));
        alphabetModels.add(new AlphabetModel("Eagle",R.drawable.e,R.drawable.eagle));
        alphabetModels.add(new AlphabetModel("Fish",R.drawable.f,R.drawable.fish));
        alphabetModels.add(new AlphabetModel("Goat",R.drawable.g,R.drawable.goat));
        alphabetModels.add(new AlphabetModel("Horse",R.drawable.h,R.drawable.horse));
        alphabetModels.add(new AlphabetModel("Ice Cream",R.drawable.i,R.drawable.ice_cream));
        alphabetModels.add(new AlphabetModel("Jug",R.drawable.j,R.drawable.jug));
        alphabetModels.add(new AlphabetModel("Kite",R.drawable.k,R.drawable.kite));
        alphabetModels.add(new AlphabetModel("Lamp",R.drawable.l,R.drawable.lamp));
        alphabetModels.add(new AlphabetModel("Moon",R.drawable.m,R.drawable.moon));
        alphabetModels.add(new AlphabetModel("Nest",R.drawable.n,R.drawable.nest));
        alphabetModels.add(new AlphabetModel("Octopus",R.drawable.o,R.drawable.octopus));
        alphabetModels.add(new AlphabetModel("Panda",R.drawable.p,R.drawable.panda));
        alphabetModels.add(new AlphabetModel("Queen",R.drawable.q,R.drawable.quuen));
        alphabetModels.add(new AlphabetModel("Rat",R.drawable.r,R.drawable.rat));
        alphabetModels.add(new AlphabetModel("Shoe",R.drawable.s,R.drawable.shoe));
        alphabetModels.add(new AlphabetModel("Train",R.drawable.t,R.drawable.train));
        alphabetModels.add(new AlphabetModel("Umbrella",R.drawable.u,R.drawable.umbrella));
        alphabetModels.add(new AlphabetModel("Van",R.drawable.v,R.drawable.van));
        alphabetModels.add(new AlphabetModel("Watch",R.drawable.w,R.drawable.watch));
        alphabetModels.add(new AlphabetModel("X-Mas",R.drawable.x,R.drawable.x_mas));
        alphabetModels.add(new AlphabetModel("Yak",R.drawable.y,R.drawable.yak));
        alphabetModels.add(new AlphabetModel("Zebra",R.drawable.z,R.drawable.zebra));



        AlphabetListAdapter adapter = new AlphabetListAdapter(AlphabetsListActivity.this,alphabetModels);
        mainRv1.setLayoutManager(new GridLayoutManager(this,1));
        mainRv1.setAdapter(adapter);

    }
}
