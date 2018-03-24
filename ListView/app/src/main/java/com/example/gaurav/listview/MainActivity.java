package com.example.gaurav.listview;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.concurrent.locks.ReadWriteLock;

public class MainActivity extends AppCompatActivity {


    ListView list;
    ArrayList<Contacts> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);
        //list.setCacheColorHint(getResources().getColor(R.color.transparent));
        contacts = new ArrayList<>();

        contacts.add(new Contacts("Gaurav Kumar", R.drawable.gaurav, R.string.Gaurav_number));
        contacts.add(new Contacts("Deepali Kumri", R.drawable.dipu, R.string.Dipu_number));
        contacts.add(new Contacts("Abhay Kumar", R.drawable.abhay, R.string.Abhay_number));
        contacts.add(new Contacts("Abhishek Upadhyay", R.drawable.abhi, R.string.Abhi_number));
        contacts.add(new Contacts("Akash Kumar", R.drawable.akash, R.string.Akash_number));
        contacts.add(new Contacts("Abhishek Khari", R.drawable.khari, R.string.Khari_number));
        contacts.add(new Contacts("Deepali Kumri", R.drawable.dipu, R.string.Dipu_number));
        contacts.add(new Contacts("Abhay Kumar", R.drawable.abhay, R.string.Abhay_number));
        contacts.add(new Contacts("Abhishek Upadhyay", R.drawable.abhi, R.string.Abhi_number));
        contacts.add(new Contacts("Akash Kumar", R.drawable.akash, R.string.Akash_number));
        contacts.add(new Contacts("Abhishek Khari", R.drawable.khari, R.string.Khari_number));
        contacts.add(new Contacts("Deepali Kumri", R.drawable.dipu, R.string.Dipu_number));
        contacts.add(new Contacts("Abhay Kumar", R.drawable.abhay, R.string.Abhay_number));
        contacts.add(new Contacts("Abhishek Upadhyay", R.drawable.abhi, R.string.Abhi_number));
        contacts.add(new Contacts("Akash Kumar", R.drawable.akash, R.string.Akash_number));
        contacts.add(new Contacts("Abhishek Khari", R.drawable.khari, R.string.Khari_number));


        MyAdapter adapter = new MyAdapter(this, contacts);

        list.setAdapter(adapter);



            }

    }


