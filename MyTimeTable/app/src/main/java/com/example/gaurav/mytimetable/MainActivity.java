package com.example.gaurav.mytimetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaurav.mytimetable.Adapter.MainAdapter;
import com.example.gaurav.mytimetable.DayModel.DaysModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mainRv1;
    ArrayList<DaysModel> daysModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainRv1 = (RecyclerView) findViewById(R.id.main_rv1);

        daysModels = new ArrayList<>();

        daysModels.add(new DaysModel("Monday"));
        daysModels.add(new DaysModel("Tuesday"));
        daysModels.add(new DaysModel("Wednesday"));
        daysModels.add(new DaysModel("Thursday"));
        daysModels.add(new DaysModel("Friday"));
        daysModels.add(new DaysModel("Saturday"));
        daysModels.add(new DaysModel("Sunday"));

        MainAdapter adapter = new MainAdapter(this, daysModels);
        mainRv1.setLayoutManager(new GridLayoutManager(this, 2));
        mainRv1.setAdapter(adapter);
    }
}