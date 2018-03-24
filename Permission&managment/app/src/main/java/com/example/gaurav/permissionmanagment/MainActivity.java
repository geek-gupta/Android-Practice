package com.example.gaurav.permissionmanagment;

import android.content.SharedPreferences;
import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
String KEY="MYKEY";
    String sharedPreferenceName="MyPref";
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        SharedPreferences sharedPref=getSharedPreferences(sharedPreferenceName,MODE_PRIVATE);
        et1.setText(sharedPref.getString(sharedPreferenceName,""));
    }

    @Override
    protected void onStop() {

        SharedPreferences sharedPreferences=getSharedPreferences("MYFILE",MODE_PRIVATE);

        sharedPreferences.edit().putString(KEY,et1.getText().toString()).commit();
        super.onStop();
    }
}
