package com.example.gaurav.databaseapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.renderscript.Sampler;
import android.util.Log;

import com.example.gaurav.databaseapplication.DBhelper.TodoTable;

/**
 * Created by gaurav on 7/6/2017.
 */

public class TodoDBhelper extends SQLiteOpenHelper {

    static String DB_NAME = "myDb";
    static int DB_VERSION = 1;


    public  static interface DB_CONSTANTS{
        String LBR = " ( ";
        String RBR = " ) ";
        String INTEGER_DATA = " INTEGER ";
        String PK =" PRIMARY KEY ";
        String autoIncre = " AUTOINCREMENT ";
        String comma = " , ";
        String txt = " Text ";
    }


    public  TodoDBhelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TodoTable.CREATE_TABLE);
        Log.d("TAg","This is the message of Database");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if(oldVersion == 1 && newVersion == 2){

        }

    }
}
