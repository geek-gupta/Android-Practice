package com.example.gaurav.gaurav;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.LinearGradient;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    private String filename="MyFile";
    private Button save;
    private String KEY="Mykey";
    private String SharedPref="MyPref";
    private EditText et1;
    int requestCode=151;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText) findViewById(R.id.et1);
        save = (Button) findViewById(R.id.save);
        SharedPreferences sharedPreferences=getSharedPreferences(SharedPref,MODE_PRIVATE);
        et1.setText(sharedPreferences.getString(KEY,""));
        Log.d("Data Dir", Environment.getDataDirectory().getAbsolutePath());
        Log.d("Root Dir", Environment.getRootDirectory().getAbsolutePath());
        Log.d("Cache Dir", Environment.getDownloadCacheDirectory().getAbsolutePath());
        Log.d("External Music Dir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        Log.d("App Files Dir",getFilesDir().toString());
        Log.d("App Files Dir",getCacheDir().toString());
        Log.d("App Files Dir",getExternalCacheDir().toString());
        Log.d("App Files Dir",getExternalFilesDir(Environment.DIRECTORY_MUSIC).toString());
        File filesDir[]=getExternalFilesDirs(null);
        for (File dir:filesDir){
            Log.d("App Files Dir",dir.toString());
        }

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    writeToFile(filename,et1.getText().toString());
                }
            });

            String output=readFromFile(filename);
        ((TextView)findViewById(R.id.tv1)).setText(output);
        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(result == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},requestCode);
        }
    }

    @Override
    protected void onStop() {
        SharedPreferences sharedPref=getSharedPreferences(SharedPref,MODE_PRIVATE);
        sharedPref.edit().putString(KEY,et1.getText().toString()).commit();
        super.onStop();
    }
    void writeToFile(String filename,String data){
        int result=ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if(result == PackageManager.PERMISSION_GRANTED) {
            File dir = Environment.getExternalStorageDirectory();
            File fileToWrite = new File(dir, filename);
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(fileToWrite);
                fileOutputStream.write(data.getBytes());
                fileOutputStream.close();
            } catch (IOException error) {
                Log.e("MainActivity", error.getMessage());
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(this.requestCode == requestCode){
            for (int i=0;i<permissions.length;i++){
                if(permissions[i].equalsIgnoreCase(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    if(grantResults[i] == PackageManager.PERMISSION_GRANTED){
                        writeToFile(filename,et1.getText().toString());
                    }
                }
            }
        }
    }

    String readFromFile(String filename){
        File filedir=Environment.getExternalStorageDirectory();
        File fileToRead= new File(filedir,filename);
        StringBuilder stringBuilder=new StringBuilder();
        try{
            BufferedReader bufferedReader=new BufferedReader(new FileReader(fileToRead));
            String currentLine;
            while ((currentLine = bufferedReader.readLine())!=null){
                stringBuilder.append(currentLine);
            }
        }catch (Exception error){
            Log.e("MianActivity",error.getMessage());
        }
        return stringBuilder.toString();
    }
}
