package com.example.gaurav.hypemessanger.MainUI;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.gaurav.hypemessanger.DataReceiver.ReceiveMessageActivity;
import com.example.gaurav.hypemessanger.Model.UserModel;
import com.example.gaurav.hypemessanger.R;
import com.example.gaurav.hypemessanger.Register.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    FirebaseDatabase db;
    RecyclerView userListRv;
    UserListAdapter adapter;
    ArrayList<UserModel> users;


    String phoneNumber;
    int count = 0;
    ArrayList<String> contact = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        db = FirebaseDatabase.getInstance();

        userListRv = (RecyclerView) findViewById(R.id.user_list_rv);

        getNumber(this.getContentResolver());
        getUser();


    }

    public void getNumber(ContentResolver cr) {
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (phones.moveToNext()) {
            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            //System.out.println(".................."+phoneNumber);
            phoneNumber = phoneNumber.trim();
            if (!contact.contains(phoneNumber)) {
                contact.add(phoneNumber);
            }

            // aa.add(phoneNumber);
        }
        //contact.add("Number of contacts : "+count);
        phones.close();// close cursor

        //display contact numbers in the list
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.msgReceivedItem) {
            Intent intent = new Intent(this, ReceiveMessageActivity.class);
            startActivity(intent);
            return true;
        }
        if (item.getItemId() == R.id.signOutUser) {
            FirebaseAuth.getInstance().signOut();
            Intent intent1 = new Intent(this, LoginActivity.class);
            startActivity(intent1);
            finish();
            return true;
        }
        if (item.getItemId() == R.id.AboutUsSection) {

            Intent intent = new Intent(this, AboutSectionUI.class);
            startActivity(intent);
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    void getUser() {
        db.getReference("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                users = new ArrayList<>();
                String currentUserToken = FirebaseInstanceId.getInstance().getToken();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    String email = dataSnapshot1.getKey();
                    String token = (String) dataSnapshot1.child("UToken").getValue();
                    String name = (String) dataSnapshot1.child("Uname").getValue();
                    String phone = (String)dataSnapshot1.child("Uphone").getValue();
                    UserModel user = new UserModel(token, name, phone, email, token, null);
                    if (!currentUserToken.equals(token))

                        for (String c: contact){
                            if(c.equals(phone))
                                users.add(user);
                        }

                }
                adapter = new UserListAdapter(UserListActivity.this, users);
                userListRv.setLayoutManager(new LinearLayoutManager(UserListActivity.this));
                userListRv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
