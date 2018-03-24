package com.codingblocks.myapplication13.DbHelper;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Nipun on 7/6/17.
 */

public class TodoDbHelper extends SQLiteOpenHelper {

    static String DB_NAME = "mydb";
    static int DB_VERSION = 1;
    String TAG="TODODBHELPER";

    public static interface DB_CONSTANTS {
        String LBR = " ( ";
        String RBR = " ) ";
        String SemiColon = " ; ";

        String INTEGER_DATA = " INTEGER ";
        String PK = " PRIMARY KEY ";
        String AI = " AUTOINCREMENT ";
        String Comma = " , ";
        String TEXT_DATA = " TEXT ";
    }



    public TodoDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d(TAG, "TodoDbHelper: constructor");
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: "+TodoTable.CREATE_TABLE_TODO);

        db.execSQL(TodoTable.CREATE_TABLE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
