package com.codingblocks.myapplication7;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnCall,btnView;
EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCall=(Button)findViewById(R.id.btnCall);
        btnView=(Button)findViewById(R.id.btnView);
        et1=(EditText)findViewById(R.id.etInput);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+et1.getText().toString()));
                startActivity(Intent.createChooser(callIntent,"Choose dialer"));

            }
        });
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewIntent = new Intent(Intent.ACTION_VIEW);
                viewIntent.setData(Uri.parse(et1.getText().toString()));
                startActivity(Intent.createChooser(viewIntent,"Choose viewer"));
            }
        });

    }
}
