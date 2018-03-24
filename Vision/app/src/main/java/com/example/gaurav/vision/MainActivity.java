package com.example.gaurav.vision;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;

import java.io.LineNumberReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView rv1;
    ArrayList<MainModel> models;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);
        return true;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv1 = (RecyclerView) findViewById(R.id.rv1);
        models = new ArrayList<>();
        models.add(new MainModel("  Garbage Cleaning  "));
        models.add(new MainModel("  Girls Safety  "));
        models.add(new MainModel("  Old Age Home  "));
        models.add(new MainModel("  Road Construction  "));
        models.add(new MainModel("  Government Services  "));

        MainAdapter adapter = new MainAdapter(this,models);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1.setAdapter(adapter);



    }


}
