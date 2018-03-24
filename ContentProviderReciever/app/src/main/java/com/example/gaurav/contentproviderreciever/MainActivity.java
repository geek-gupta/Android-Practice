package com.example.gaurav.contentproviderreciever;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String tablename = "Todo";
        String authority = "com.example.gaurav.databaseapplication.MycontentProvider";
        Uri contenturi=Uri.parse("content://"+authority+"/Todo");
        ContentProviderClient contentProvider=getContentResolver().acquireContentProviderClient(contenturi);
        try {
            Cursor cursor= contentProvider.query(contenturi,null,null,null,null);
            if(cursor==null) {
                Toast.makeText(this, "Was null", Toast.LENGTH_SHORT).show();
                return;
            }
            ArrayList<TodoModel>models=TodoTable.getTasks(cursor);
            Toast.makeText(this,"Message"+models.size(),Toast.LENGTH_SHORT).show();
            Log.d("Size",String.valueOf(models.size()));
            TodoModel task_model1=models.get(2);
            //textView.setText(task_model1.getTask());



//            for (PackageInfo pack : getPackageManager().getInstalledPackages(PackageManager.GET_PROVIDERS)) {
//                ProviderInfo[] providers = pack.providers;
//                if (providers != null) {
//                    for (ProviderInfo provider : providers) {
//                        Log.d("Example", "provider: " + provider.authority);
//                    }
//                }
//            }
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
