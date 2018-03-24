package com.example.gaurav.hypemessanger.DbHandler;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by gaurav on 7/23/2017.
 */

public class Dbhelper extends SQLiteOpenHelper {
    static String DB_NAME = "myDb";
    static int DB_VERSION = 1;

    public  Dbhelper(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbTable.CMD_CREATE_USER_TABLE);
        db.execSQL(DbTable.CMD_CREATE_AUTHENTICATION_TABLE);
        db.execSQL(DbTable.CMD_CREATE_DATA_TABLE);
        db.execSQL(DbTable.CMD_CREATE_GROUP_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }
}
