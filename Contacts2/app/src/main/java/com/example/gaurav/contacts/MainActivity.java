package com.example.gaurav.contacts;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    static ArrayList<Contacts> contacts;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




            list = (ListView) findViewById(R.id.list);
            //list.setCacheColorHint(getResources().getColor(R.color.transparent));
            contacts = new ArrayList<>();

            contacts.add(new Contacts("Gaurav Kumar", R.drawable.gaurav, getString(R.string.Gaurav_number)));
            contacts.add(new Contacts("Deepali Kumri", R.drawable.dipu, getString(R.string.Dipu_number)));
            contacts.add(new Contacts("Abhay Kumar", R.drawable.abhay, getString(R.string.Abhay_number)));
            contacts.add(new Contacts("Abhishek Upadhyay", R.drawable.abhi, getString(R.string.Abhi_number)));
            contacts.add(new Contacts("Akash Kumar", R.drawable.akash, getString(R.string.Akash_number)));
            contacts.add(new Contacts("Abhishek Khari", R.drawable.khari, getString(R.string.Khari_number)));
            contacts.add(new Contacts("Deepali Kumri", R.drawable.dipu, getString(R.string.Dipu_number)));
            contacts.add(new Contacts("Abhay Kumar", R.drawable.abhay, getString(R.string.Abhay_number)));
            contacts.add(new Contacts("Abhishek Upadhyay", R.drawable.abhi, getString(R.string.Abhi_number)));
            contacts.add(new Contacts("Akash Kumar", R.drawable.akash, getString(R.string.Akash_number)));
            contacts.add(new Contacts("Abhishek Khari", R.drawable.khari,getString( R.string.Khari_number)));
            contacts.add(new Contacts("Deepali Kumri", R.drawable.dipu, getString(R.string.Dipu_number)));
            contacts.add(new Contacts("Abhay Kumar", R.drawable.abhay, getString(R.string.Abhay_number)));
            contacts.add(new Contacts("Abhishek Upadhyay", R.drawable.abhi,getString( R.string.Abhi_number)));
            contacts.add(new Contacts("Akash Kumar", R.drawable.akash, getString(R.string.Akash_number)));
            contacts.add(new Contacts("Abhishek Khari", R.drawable.khari, getString(R.string.Khari_number)));


             adapter = new MyAdapter(this, contacts);

            list.setAdapter(adapter);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    //startActivity(intent);
                    //adapter.notifyDataSetChanged();
                    startActivityForResult(intent,234);
                }
            });
        }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==234){
            if(resultCode==RESULT_OK){
                String name = data.getStringExtra("name");
                String number = data.getStringExtra("number");

                contacts.add(new Contacts(name,R.drawable.gaurav,number));
                adapter.notifyDataSetChanged();



            }
        }
    }
}

