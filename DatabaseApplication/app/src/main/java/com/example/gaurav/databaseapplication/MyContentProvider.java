package com.example.gaurav.databaseapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.gaurav.databaseapplication.DBhelper.TodoTable;

public class MyContentProvider extends ContentProvider {
    String authority = "com.example.gaurav.databaseapplication.MyContentProvider";


    TodoDBhelper todoDBhelper;
    SQLiteDatabase db;

    public MyContentProvider() {
    }
   @Override
    public boolean onCreate() {
        todoDBhelper = new TodoDBhelper(getContext());
        db = todoDBhelper.getWritableDatabase();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        Log.d("URI", "query: "+uri);
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(authority, TodoTable.TABLE_NAME, 0);
        uriMatcher.addURI(authority, TodoTable.TABLE_NAME + "/#", 1);
        Cursor cursor = null;
        String[] PROJECTIONS = {TodoTable.columns.COLUMN_ID, TodoTable.columns.COLUMN_TASK};
        cursor = db.query(TodoTable.TABLE_NAME, PROJECTIONS, null, null, null, null, null);

        if (uriMatcher.match(uri) == 0) {
            Log.d("Cursor_provider", "query: in 0");
            cursor = db.query(TodoTable.TABLE_NAME, PROJECTIONS, null, null, null, null, null);
        } else if (uriMatcher.match(uri) == 1) {
            Log.d("Cursor_provider", "query: in 1");
            ContentValues values = new ContentValues();
            String whereClause = " id = ? ";
            cursor = db.query(TodoTable.TABLE_NAME, projection, whereClause,
                    new String[]{String.valueOf(uri.getPathSegments().get(1))}, null, null, null);
        }
        Log.d("Cursor_provider", "query: ");
//        cursor.setNotificationUri(getContext().getContentResolver(), uri);
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

}
