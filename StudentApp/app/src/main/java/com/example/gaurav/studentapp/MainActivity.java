package com.example.gaurav.studentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

   private EditText getnum1,getnum2;
   private Button add;
   private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getnum1 = (EditText) findViewById(R.id.getNum1);
        getnum2 = (EditText) findViewById(R.id.getNum2);
        add = (Button) findViewById(R.id.addnum);
        result = (TextView) findViewById(R.id.result);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String num1 = getnum1.getText().toString();
                int a = Integer.parseInt(getnum1.getText().toString());
                //String num2 = getnum2.getText().toString();
                int b = Integer.parseInt(getnum2.getText().toString());
                int c = a+b;
                result.setText(""+c);
            }
        });


    }


}
