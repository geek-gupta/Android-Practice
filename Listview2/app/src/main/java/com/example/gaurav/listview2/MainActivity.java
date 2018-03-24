package com.example.gaurav.listview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    ArrayList<Display> displays;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        displays=new ArrayList<>();

        displays.add(new Display(1));
        displays.add(new Display(2));
        displays.add(new Display(4));
        displays.add(new Display(5));
        displays.add(new Display(6));
        displays.add(new Display(7));



        MyAdapter adapter=new MyAdapter(this,displays);
        list.setAdapter(adapter);


    }
}
