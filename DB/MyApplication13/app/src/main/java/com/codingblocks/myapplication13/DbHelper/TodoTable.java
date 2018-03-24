package com.codingblocks.myapplication13.DbHelper;

/**
 * Created by Nipun on 7/6/17.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.codingblocks.myapplication13.models.TodoModel;

import java.util.ArrayList;

import static com.codingblocks.myapplication13.DbHelper.TodoDbHelper.DB_CONSTANTS.*;

public class TodoTable {
    static final String TABLE_NAME = "Todo";
static String TAG="TODDO TABle";
    public static interface columns {
        String COLUMN_ID = "id";
        String COLUMN_TASK = "task";
    }

    static final String CREATE_TABLE_TODO =
            "Create Table " + TABLE_NAME +
                    LBR + columns.COLUMN_ID
                    + INTEGER_DATA +
                    PK +
                    AI + Comma +
                    columns.COLUMN_TASK +
                    TEXT_DATA +
                    RBR +
                    SemiColon;

    public static boolean insert(SQLiteDatabase db, String task) {
        if (db.isReadOnly()) {
            return false;
        }
        Log.d(TAG, "insert: "+task);
        ContentValues values = new ContentValues();
        values.put(columns.COLUMN_TASK, task);

        db.insert(TABLE_NAME, null, values);
        return true;
    }

    public static ArrayList<TodoModel> getTasks(SQLiteDatabase db) {
        String[] PROJECTIONS = {columns.COLUMN_ID, columns.COLUMN_TASK};
        Cursor cursor = db.query(TABLE_NAME, PROJECTIONS,
                null, null, null, null, null);
        cursor.moveToFirst();
        int columnId = cursor.getColumnIndex(String.valueOf(columns.COLUMN_ID));
        int columnTask = cursor.getColumnIndex(columns.COLUMN_TASK);
        ArrayList<TodoModel> todoModels = new ArrayList<>();
        if(cursor.getCount()>0) {
            do {
                TodoModel todo = new TodoModel(cursor.getInt(columnId),
                        cursor.getString(columnTask));
                todoModels.add(todo);
            }while (cursor.moveToNext());
        }
        return todoModels;
//        String query= " SELECT * FROM "+TABLE_NAME;
  //      db.rawQuery(query,null);
    }
}
