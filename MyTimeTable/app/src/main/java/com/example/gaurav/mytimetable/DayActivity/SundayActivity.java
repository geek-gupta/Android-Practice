package com.example.gaurav.mytimetable.DayActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaurav.mytimetable.Adapter.MonDayAdapter;
import com.example.gaurav.mytimetable.DayModel.MondayModel;
import com.example.gaurav.mytimetable.R;

import java.util.ArrayList;

public class SundayActivity extends AppCompatActivity {

    RecyclerView dayRv;
    ArrayList<MondayModel> dayModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        dayRv = (RecyclerView) findViewById(R.id.monday_rv);

        dayModels = new ArrayList<>();

        dayModels.add(new MondayModel("Sleeping Time : ","1:00 Am","7:00 Am"));
        dayModels.add(new MondayModel("Revise java : ","7:00 Am","8:00 Pm"));
        dayModels.add(new MondayModel("Java Coaching : ","8:30 Am","10:30 Am"));
        dayModels.add(new MondayModel("Sleep : ","11:00 Am","1:00 Pm"));
        dayModels.add(new MondayModel("Miscllaneous : ","1:00 Pm","2:30 Pm"));
        dayModels.add(new MondayModel("College Studies : ","2:30 Pm","4:30 Pm"));
        dayModels.add(new MondayModel("GF Talking : ","4:30 Pm","6:00 Pm"));
        dayModels.add(new MondayModel("Miscllaneous : ","6:00 Pm","8:30 Pm"));
        dayModels.add(new MondayModel("Java Learning :","9:30 Pm","1:00 Am"));

        MonDayAdapter adapter = new MonDayAdapter(this, dayModels);
        dayRv.setLayoutManager(new LinearLayoutManager(this));
        dayRv.setAdapter(adapter);
    }
}

