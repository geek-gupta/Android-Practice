package com.example.gaurav.mytimetable.DayActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.gaurav.mytimetable.Adapter.MonDayAdapter;
import com.example.gaurav.mytimetable.DayModel.MondayModel;
import com.example.gaurav.mytimetable.R;

import java.util.ArrayList;

public class SaturdayActivity extends AppCompatActivity {

    RecyclerView dayRv;
    ArrayList<MondayModel> dayModels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monday);

        dayRv = (RecyclerView) findViewById(R.id.monday_rv);

        dayModels = new ArrayList<>();

        dayModels.add(new MondayModel("Sleeping Time : ","1:00 Am","8:00 Am"));
        dayModels.add(new MondayModel("Aptitude Test : ","9:00 Am","12:00 Pm"));
        dayModels.add(new MondayModel("Miscellaneous : ","12:00 Pm","2:00 Pm"));
        dayModels.add(new MondayModel("Chess Play : ","2:00 Pm","4:00 Pm"));
        dayModels.add(new MondayModel("GF Talking : ","4:00 Pm","5:30 Pm"));
        dayModels.add(new MondayModel("Nasta : ","5:30 Pm","6:00 Pm"));
        dayModels.add(new MondayModel("HTML 5 Learning : ","6:00 Pm","8:00 Pm"));
        dayModels.add(new MondayModel("Miscllaneous : ","8:00 Pm","10:00 Pm"));
        dayModels.add(new MondayModel("College Studies :","10:00 Pm","1:00 Am"));

        MonDayAdapter adapter = new MonDayAdapter(this, dayModels);
        dayRv.setLayoutManager(new LinearLayoutManager(this));
        dayRv.setAdapter(adapter);
    }
}
