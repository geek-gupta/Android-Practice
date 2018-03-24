package com.example.gaurav.intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Button dial,view;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = (EditText) findViewById(R.id.number);
        dial = (Button) findViewById(R.id.dial);
        view = (Button) findViewById(R.id.view);

        dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = number.getText().toString();
                 intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+num));
                startActivity(intent);
            }
        });
       view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = number.getText().toString();
                 intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http:"+url));
                startActivity(intent);

            }
        });
    }
}
