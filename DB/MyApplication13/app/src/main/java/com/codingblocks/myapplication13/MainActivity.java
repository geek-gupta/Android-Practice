package com.codingblocks.myapplication13;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codingblocks.myapplication13.DbHelper.TodoDbHelper;
import com.codingblocks.myapplication13.DbHelper.TodoTable;
import com.codingblocks.myapplication13.models.TodoModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    TodoListAdapter adapter;
    ArrayList<TodoModel> todoModels;
    Button btnAddClick;
    EditText etTask;
    String sharedPref = "SharedPREF";
    String sharedPrefKey = "StringKey";
    SharedPreferences spref;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        todoModels = new ArrayList<>();

        spref = getSharedPreferences(sharedPref, MODE_PRIVATE);
        /*for (String key : spref.getAll().keySet()) {
            todoModels.add(new TodoModel(Integer.parseInt(key), spref.getString(key, "")));
        }*/

        TodoDbHelper dbhelper=new TodoDbHelper(this);
         db = dbhelper.getWritableDatabase();
        todoModels = TodoTable.getTasks(db);

        adapter = new TodoListAdapter(this, todoModels);

        etTask = (EditText) findViewById(R.id.et_task);
        btnAddClick = (Button) findViewById(R.id.btn_add);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAddClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoModel todos = new TodoModel(etTask.getText().toString());
                todoModels.add(todos);
                etTask.setText("");

                TodoTable.insert(db,todos.getTask());
                adapter.notifyDataSetChanged();
                //spref.edit().putString(String.valueOf(todos.getId()),
                  //      todos.getTask()).commit();
            }
        });
    }

    @Override
    protected void onStop() {
        SharedPreferences spref = getSharedPreferences(sharedPref, MODE_PRIVATE);
        for (TodoModel todo : todoModels) {
            //    spref.edit().putString(String.valueOf(todo.getId()), todo.getTask()).commit();
        }
        super.onStop();

    }
}
