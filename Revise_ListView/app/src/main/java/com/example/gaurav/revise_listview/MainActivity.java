package com.example.gaurav.revise_listview;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> students;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=(ListView) findViewById(R.id.list);
        students=new ArrayList<>();


        students.add(new Student(19,"Gaurav","pandora"));
        students.add(new Student(21,"ravi","pandora"));
        students.add(new Student(29,"kisan","crux"));
        students.add(new Student(23,"Ram","pandora"));
        students.add(new Student(24,"Rama","elixir"));
        students.add(new Student(21,"Soumya","pandora"));
        students.add(new Student(19,"Gaurav","pandora"));
        students.add(new Student(21,"ravi","pandora"));
        students.add(new Student(29,"kisan","crux"));
        students.add(new Student(23,"Ram","pandora"));
        students.add(new Student(24,"Rama","elixir"));
        students.add(new Student(21,"Soumya","pandora"));
        students.add(new Student(19,"Gaurav","pandora"));
        students.add(new Student(21,"ravi","pandora"));
        students.add(new Student(29,"kisan","crux"));
        students.add(new Student(23,"Ram","pandora"));
        students.add(new Student(24,"Rama","elixir"));
        students.add(new Student(21,"Soumya","pandora"));
        students.add(new Student(19,"Gaurav","pandora"));
        students.add(new Student(21,"ravi","pandora"));
        students.add(new Student(29,"kisan","crux"));
        students.add(new Student(23,"Ram","pandora"));
        students.add(new Student(24,"Rama","elixir"));
        students.add(new Student(21,"Soumya","pandora"));





        StudentAdapter adapter=new StudentAdapter(this,students);
        list.setAdapter(adapter);
    }
}
