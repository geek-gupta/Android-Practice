//package com.example.gaurav.hypemessanger.MainUI;
//
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//
//import com.example.gaurav.hypemessanger.Model.UserModel;
//import com.example.gaurav.hypemessanger.R;
//import com.google.firebase.database.DataSnapshot;
//import com.google.firebase.database.DatabaseError;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.iid.FirebaseInstanceId;
//
//import org.w3c.dom.Text;
//
//import java.util.ArrayList;
//
//public class TextSenderActivity extends AppCompatActivity implements View.OnClickListener {
//
//    FirebaseDatabase db;
//    EditText msgSend;
//    Button msgSendBtn;
//    ArrayList<UserModel> userModels;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_text_sender);
//        db = FirebaseDatabase.getInstance();
//
//        msgSendBtn = (Button) findViewById(R.id.msgSendbtn);
//        msgSend = (EditText) findViewById(R.id.msgText);
//        msgSendBtn.setOnClickListener(this);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
//
//
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == android.R.id.home){
//            finish();
//            overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.msgSendbtn:
//                db.getReference("users").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        userModels = new ArrayList<>();
//                        String currentUserToken = FirebaseInstanceId.getInstance().getToken();
//                        for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
//
//                            String email = dataSnapshot1.getKey();
//                            String token = (String) dataSnapshot1.child("UToken").getValue();
//                            String name = (String) dataSnapshot1.child("Uname").getValue();
//                            UserModel user = new UserModel(token, name, null, email, token, null);
//                            if(!currentUserToken.equals(token))
//                            userModels.add(user);
//                        }
//                        createMyDialog();
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//                break;
//
//        }
//    }
//
//    private void createMyDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Select Image Source");
//        builder.setAdapter(new ListAdapter(), new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                UserModel userModel = userModels.get(which);
//                db.getReference("users").child(userModel.getEmail()).
//                        child("data").child(FirebaseInstanceId.getInstance().getToken())
//                        .child(String.valueOf(System.currentTimeMillis()))
//                        .child("text").setValue(msgSend.getText().toString());
//            }
//        });
//
//        AlertDialog dialog;
//        dialog = builder.create();
//        dialog.show();
//    }
//    class ListAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return userModels.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return userModels.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            if(convertView==null){
//                convertView = LayoutInflater.from(TextSenderActivity.this).inflate(R.layout.sender_list_item,parent,false);
//            }
//            String name = userModels.get(position).getName();
//            TextView sendToName = (TextView) convertView.findViewById(R.id.sendToName);
//            sendToName.setText(name);
//            return convertView;
//        }
//    }
//}
