package com.example.gaurav.contactlistfromphone;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String phoneNumber;
    ListView lv;
    int count=0;
    ArrayList<String> aa= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        lv= (ListView) findViewById(R.id.lv);

        getNumber(this.getContentResolver());
    }

    public void getNumber(ContentResolver cr)
    {
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            //System.out.println(".................."+phoneNumber);
            phoneNumber = phoneNumber.trim();
            if(!aa.contains(phoneNumber)){
                aa.add(phoneNumber);
                count++;
            }

           // aa.add(phoneNumber);
        }
        aa.add("Number of contacts : "+count);
        phones.close();// close cursor
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,aa);
        lv.setAdapter(adapter);
        //display contact numbers in the list
    }
}