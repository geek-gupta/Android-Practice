package com.example.gaurav.contacts;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText name,number;
    Button btn;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

         name=(EditText) findViewById(R.id.name);
         number=(EditText) findViewById(R.id.number);
        btn=(Button) findViewById(R.id.btn);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendingIntent=new Intent();
                String a=name.getText().toString();
                sendingIntent.putExtra("name",a);
                String number1= number.getText().toString();
                sendingIntent.putExtra("number",number1);

                setResult(RESULT_OK,sendingIntent);
                finish();

            }
        });


    }
}
