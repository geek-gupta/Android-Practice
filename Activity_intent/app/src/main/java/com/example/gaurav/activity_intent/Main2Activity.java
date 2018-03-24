package com.example.gaurav.activity_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Intent intentReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        intentReceiver = getIntent();
        final TextView t1 = (TextView) findViewById(R.id.t1);
        final TextView t2 = (TextView) findViewById(R.id.t2);
        Button btn = (Button) findViewById(R.id.btn_send);
        t1.setText(intentReceiver.getExtras().getString(Constants.KEY));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendingIntent = new Intent();
                //sendingIntent.putExtra(Constants.KEY2,t2.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putString("Key3", "data1");
                bundle.putString("Key4", "data2");
                bundle.putString("Key5", "data3");
                bundle.putInt("Key6", 34);
                sendingIntent.putExtra("bundleKey", bundle);
                setResult(RESULT_OK, sendingIntent);
                finish();
            }
        });
    }


}
