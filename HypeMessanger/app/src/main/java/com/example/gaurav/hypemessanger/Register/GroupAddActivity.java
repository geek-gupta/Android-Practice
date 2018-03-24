package com.example.gaurav.hypemessanger.Register;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gaurav.hypemessanger.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GroupAddActivity extends AppCompatActivity {
    ArrayAdapter<String> spinnerAdapter;
    ArrayList<String> groupList;
    Spinner groupSpinner;
    Button groupAdd;
    FirebaseDatabase db;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_add);
        groupSpinner = (Spinner) findViewById(R.id.group_spinner);
        groupAdd = (Button) findViewById(R.id.group_add);

        db = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        groupList = new ArrayList<>();
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, groupList);
        groupSpinner.setSelection(groupList.size());
        groupSpinner.setAdapter(spinnerAdapter);

        db.getReference("groups").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //  groupList = new ArrayList<>();
                groupList.clear();
                //String currentUserToken = FirebaseInstanceId.getInstance().getToken();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//                    String token = (String) dataSnapshot1.child("UToken").getValue();
                    String name = (String) dataSnapshot1.getValue();
                    groupList.add(name);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        groupAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(SignUpActivity.this, "InGroupAdd", Toast.LENGTH_SHORT).show();
                final EditText groupNameEdittxt = new EditText(GroupAddActivity.this);
                new AlertDialog.
                        Builder(GroupAddActivity.this).
                        setTitle("Group Name").
                        setMessage("Enter Group Name").
                        setView(groupNameEdittxt).setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (groupNameEdittxt != null && !groupNameEdittxt.getText().toString().isEmpty()) {
                            String groupName = groupNameEdittxt.getText().toString();
                            db.getReference("groups").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Toast.makeText(GroupAddActivity.this, "ondatachange", Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    Toast.makeText(GroupAddActivity.this, "oncancelled", Toast.LENGTH_SHORT).show();
                                }
                            });
                            groupList.add(groupName);

                        } else
                            Toast.makeText(GroupAddActivity.this, "Enter Group Name to add", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancel", null).show();
            }
        });
    }
}
