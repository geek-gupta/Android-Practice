package com.example.gaurav.day_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.logging.StreamHandler;

import static android.R.layout.simple_expandable_list_item_2;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    ArrayList<String> list1;
    ArrayList<Contacts> contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView1=(ListView)findViewById(R.id.listView1);


        contacts =new ArrayList<>();
        contacts.add(new Contacts("A",R.drawable.sample_7));
        contacts.add(new Contacts("B",R.drawable.gaurav));
        contacts.add(new Contacts("C",R.drawable.gauravkumar));

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });
        MyAdapter adapter = new MyAdapter(this,contacts);
        listView1.setAdapter(adapter);
    }

}

