package com.example.gaurav.hypemessanger.ChatPackage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gaurav.hypemessanger.CommonUtils.Constants;
import com.example.gaurav.hypemessanger.Model.ChatModel;
import com.example.gaurav.hypemessanger.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ChatListActivity extends AppCompatActivity {


    FirebaseDatabase db;
    private RecyclerView userListRv;
    private ChatListAdapter adapter;
    private String otherUserToken, otherUserEmail,otherUserName;
    private EditText sendText;
    private Button sendButton;
    private ArrayList<ChatModel> sent, recieved;
    private String currentUserToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        currentUserToken = FirebaseInstanceId.getInstance().getToken();


        otherUserToken = getIntent().getStringExtra(Constants.USER_TOKEN_KEY);
        otherUserEmail = getIntent().getStringExtra(Constants.USER_EMAIL_KEY);
        otherUserName = getIntent().getStringExtra(Constants.USER_NAME_KEY);
        getSupportActionBar().setTitle(otherUserName.toUpperCase());
        db = FirebaseDatabase.getInstance();

        userListRv = (RecyclerView) findViewById(R.id.chat_rv);
        sendText = (EditText) findViewById(R.id.send_text);
        sendButton = (Button) findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sendText.getText() != null && !sendText.getText().toString().isEmpty()) {
                    sendMsg();
                    sendText.setText("");
                } else {
                    Toast.makeText(ChatListActivity.this, "Enter Message to send", Toast.LENGTH_SHORT).show();
                }
            }
        });


        getUserMessages();

    }

    void getUserMessages() {
        db.getReference("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                recieved = new ArrayList<ChatModel>();
                sent = new ArrayList<ChatModel>();

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String token = (String) dataSnapshot1.child("UToken").getValue();
                    if (token != null && token.equals(currentUserToken)) {
                        for (DataSnapshot dataSnapshot2 : dataSnapshot1.child("data").getChildren()) {
                            if (dataSnapshot2.getKey().equals(otherUserToken)) {
                                for (DataSnapshot msgSnapshots : dataSnapshot2.getChildren()) {
                                    String timeStamp = msgSnapshots.getKey();
                                    String msg = (String) msgSnapshots.child("text").getValue();
                                    recieved.add(new ChatModel(msg, Long.parseLong(timeStamp), otherUserToken, 0));
                                }
                            }
                        }
                    }
                    if (token != null && token.equals(otherUserToken)) {
                        for (DataSnapshot dataSnapshot2 : dataSnapshot1.child("data").getChildren()) {
                            if (dataSnapshot2.getKey().equals(currentUserToken)) {
                                for (DataSnapshot msgSnapshots : dataSnapshot2.getChildren()) {
                                    String timeStamp = msgSnapshots.getKey();
                                    String msg = (String) msgSnapshots.child("text").getValue();
                                    recieved.add(new ChatModel(msg, Long.parseLong(timeStamp), currentUserToken, 1));
                                }
                            }
                        }
                    }


                }

                Collections.sort(recieved, new Comparator<ChatModel>() {
                    @Override
                    public int compare(ChatModel o1, ChatModel o2) {
                        if (o1.getTimeStamp() > o2.getTimeStamp()) {
                            return 0;
                        } else {
                            return -1;
                        }

                    }
                });
                adapter = new ChatListAdapter(ChatListActivity.this, recieved);
                userListRv.setLayoutManager(new LinearLayoutManager(ChatListActivity.this));
                userListRv.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    void sendMsg() {
        db.getReference("users").child(otherUserEmail).
                child("data").child(FirebaseInstanceId.getInstance().getToken())
                .child(String.valueOf(System.currentTimeMillis()))
                .child("text").setValue(sendText.getText().toString());
    }
}
