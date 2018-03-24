package com.example.gaurav.databaseapplication;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.gaurav.databaseapplication.DBhelper.TodoTable;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    EditText et1;
    Button btn;
    String shpref="";
    TodoListAdapter adapter;
    SharedPreferences sharedPreferences;
    SQLiteDatabase db;
    ArrayList<TodoModel> todomodels;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<TodoModel> models = new ArrayList<>();
        rv1 = (RecyclerView) findViewById(R.id.rv1);
        et1 = (EditText) findViewById(R.id.et1);
        btn = (Button) findViewById(R.id.btnAdd);

        TodoDBhelper todoDBhelper = new TodoDBhelper(this);
        db = todoDBhelper.getWritableDatabase();
        todomodels = TodoTable.getTasks(db);
        //sharedPreferences = getSharedPreferences(shpref,MODE_PRIVATE);
        /*for(String key : sharedPreferences.getAll().keySet()){
            models.add(new TodoModel(Integer.parseInt(key),sharedPreferences.getString(key,"")));
        }*/

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoModel model = new TodoModel(et1.getText().toString());
                todomodels.add(model);
                TodoTable.insert(db,model.getTask() );
                //sharedPreferences.edit().putString(String.valueOf(model.getId()),model.getTask()).commit();
                adapter.notifyDataSetChanged();
            }
        });


        adapter = new TodoListAdapter(MainActivity.this, todomodels);

        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1.setAdapter(adapter);


    }


}
