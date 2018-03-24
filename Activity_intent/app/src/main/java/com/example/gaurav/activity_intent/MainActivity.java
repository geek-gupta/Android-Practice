package com.example.gaurav.activity_intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    Button btn_launch;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            et1=(EditText) findViewById(R.id.et1);
            btn_launch=(Button) findViewById(R.id.btn_launch);
            t1=(TextView) findViewById(R.id.t1);
        btn_launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra(Constants.KEY,et1.getText().toString());
                //startActivity(intent);
                //For Receiving Back
                startActivityForResult(intent,234);

            }


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==234){
            if(resultCode==RESULT_OK){
                String result = data.getStringExtra(Constants.KEY2);

                Bundle mybundle=data.getBundleExtra("bundleKey");
                String stringData=mybundle.getString("Key3");
                t1.setText(stringData);
            }
        }
    }
}
