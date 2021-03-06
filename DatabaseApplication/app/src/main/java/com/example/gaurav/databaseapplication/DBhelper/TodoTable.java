package com.example.gaurav.databaseapplication.DBhelper;

/**
 * Created by gaurav on 7/6/2017.
 */
import android.app.ActionBar;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gaurav.databaseapplication.TodoDBhelper;
import com.example.gaurav.databaseapplication.TodoModel;

import java.util.ArrayList;

import static com.example.gaurav.databaseapplication.TodoDBhelper.DB_CONSTANTS.*;

public class TodoTable {
    public TodoTable() {
    }

    public static final String TABLE_NAME ="Todo";
    public  static  interface  columns{
        String COLUMN_ID = "id";
        String COLUMN_TASK="task";
        String COLUMN_DONE="is_done";
    }
    public static  final String CREATE_TABLE =
            " create Table " + TABLE_NAME +
                    LBR + columns.COLUMN_ID + INTEGER_DATA + PK +
                     comma +
                    columns.COLUMN_TASK +
                    txt + RBR + ";";
    public static final String CMD_UPDATE_TABLE_VERSION_1 = "";


   public static boolean insert  (SQLiteDatabase db, String task){

        if(db.isReadOnly())
            return false;
        TodoModel todo = new TodoModel(task);
        ContentValues values = new ContentValues();
        values.put(columns.COLUMN_TASK,task);
        db.insert(TABLE_NAME,null,values);
        return  true;
    }
    public static ArrayList<TodoModel> getTasks(SQLiteDatabase db){
        String[] PROJECTIONS = {columns.COLUMN_ID,columns.COLUMN_TASK};
        Cursor cursor = db.query(TABLE_NAME,PROJECTIONS,null,null,null,null,null);
        cursor.moveToFirst();
        int columnId = cursor.getColumnIndex(columns.COLUMN_ID);
        int columnTask = cursor.getColumnIndex(columns.COLUMN_TASK);
        ArrayList<TodoModel> todoModels=new ArrayList<>();
        while(cursor.moveToNext()){
            TodoModel todo = new TodoModel(cursor.getInt(columnId),cursor.getString(columnTask));
            todoModels.add(todo);
        }

        return todoModels;
        //String query = "SELECT * FROM " + TABLE_NAME;
        //db.rawQuery(query,null);
    }
}
