package com.example.gaurav.recycler_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Student> students=new ArrayList<>();
        RecyclerView rv1= (RecyclerView) findViewById(R.id.rv1);

        students.add(new Student(12,"gaurav","pandora"));
        students.add(new Student(22,"saurav","elixir"));
        students.add(new Student(32,"neha","crux"));
        students.add(new Student(18,"ekta","html"));
        students.add(new Student(12,"abhishek","css"));


        StudentAdapter adapter=new StudentAdapter(this,students);
        rv1.addItemDecoration(new SimpleDividerItemDecoration(
                getApplicationContext()
        ));
        rv1.setLayoutManager(new GridLayoutManager(this,2));


        rv1.setAdapter(adapter);
    }
}
