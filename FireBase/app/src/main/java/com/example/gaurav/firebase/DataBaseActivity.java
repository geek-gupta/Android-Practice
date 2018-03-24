package com.example.gaurav.firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataBaseActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference myRef;
    EditText editText;
    Button send,fetch;
    TextView setTextFromDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        editText = (EditText) findViewById(R.id.EDitText);
        send = (Button) findViewById(R.id.sendToDb);
        fetch = (Button) findViewById(R.id.fetchFromDb);
        setTextFromDb= (TextView) findViewById(R.id.textView);
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRef.setValue(editText.getText().toString());
            }
        });




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                setTextFromDb.setText(value);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(DataBaseActivity.this, "Failed to Read value", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
