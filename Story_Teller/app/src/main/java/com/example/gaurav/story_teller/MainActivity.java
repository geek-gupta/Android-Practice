package com.example.gaurav.story_teller;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mnamefield;
    private Button mstartbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mnamefield = (EditText)findViewById(R.id.editText);
        mstartbutton =(Button)findViewById(R.id.submit_name);

        mstartbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=mnamefield.getText().toString();
                Toast.makeText(MainActivity.this, name, Toast.LENGTH_LONG).show();
                startStory();
            }
        });
    }

    private void startStory(){
        Intent intent=new Intent(this,storyActivity.class);
        startActivity(intent);
    }



}
