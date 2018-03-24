package com.example.gaurav.kidzoo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaurav.kidzoo.ItemList.ItemListAdapter;
import com.example.gaurav.kidzoo.ItemList.ItemModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemModel> itemModels;
    RecyclerView mainRv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRv1 = (RecyclerView) findViewById(R.id.item_list);
        itemModels = new ArrayList<>();


        itemModels.add(new ItemModel("Alphabets",R.drawable.a));
        itemModels.add(new ItemModel("Numbers",R.drawable.numbers));
        itemModels.add(new ItemModel("Animals",R.drawable.panda));
        itemModels.add(new ItemModel("States",R.drawable.states));
        itemModels.add(new ItemModel("Fruits",R.drawable.apple));
        itemModels.add(new ItemModel("Flowers",R.drawable.flowers));
        itemModels.add(new ItemModel("Games",R.drawable.game));
        itemModels.add(new ItemModel("Shapes",R.drawable.shape));
        itemModels.add(new ItemModel("Vegetables",R.drawable.vegetables));

        ItemListAdapter adapter = new ItemListAdapter(MainActivity.this,itemModels);
        mainRv1.setLayoutManager(new GridLayoutManager(this,3));
        mainRv1.setAdapter(adapter);

    }
}
