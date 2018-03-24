package com.example.gaurav.hypemessanger.DataReceiver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaurav.hypemessanger.Model.MessageModel;
import com.example.gaurav.hypemessanger.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.ArrayList;
import java.util.HashMap;


public class ReceiveMessageActivity extends AppCompatActivity {
    ArrayList<String> messages;
    FirebaseDatabase db;
    DatabaseReference myref;
    RecyclerView recyclerView;
    ArrayList<MessageModel> messageModels;
    ReceivedMessageAdapter receivedMessageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        recyclerView = (RecyclerView) findViewById(R.id.recievedRecycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseDatabase.getInstance();
        myref = db.getReference();
        db.getReference("users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HashMap<String, String> nameTokenMap = new HashMap<String, String>();
                String currentToken = FirebaseInstanceId.getInstance().getToken();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String token = (String) dataSnapshot1.child("UToken").getValue();
                    String name = (String) dataSnapshot1.child("Uname").getValue();
                    nameTokenMap.put(token, name);

                }
                messages = new ArrayList<String>();
                messageModels = new ArrayList<MessageModel>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String token = (String) dataSnapshot1.child("UToken").getValue();
                    if (token !=null && token.equals(currentToken)) {
                        for (DataSnapshot dataSnapshot2 : dataSnapshot1.child("data").getChildren()) {
                            String senderName = nameTokenMap.get(dataSnapshot2.getKey());
                            for (DataSnapshot msgSnapshots : dataSnapshot2.getChildren()) {
                                String timeStamp = msgSnapshots.getKey();
                                String msg = (String) msgSnapshots.child("text").getValue();
                                messages.add(msg);
                                MessageModel msgModel = new MessageModel(senderName, timeStamp, msg);
                                messageModels.add(msgModel);
                            }
                        }
                    }
                }
//                Intent intent = new Intent(ReceiveMessageActivity.this,DataOverlayManagerService.class);
//                if(messages!=null && messages.size()!=0)
//                    intent.putExtra(Constants.DATA_KEY,messages.get(messages.size()-1));
//                startService(intent);
                receivedMessageAdapter = new ReceivedMessageAdapter(ReceiveMessageActivity.this,
                        messageModels);
                recyclerView.setAdapter(receivedMessageAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
