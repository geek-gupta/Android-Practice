package com.example.gaurav.whatsapp.status;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurav.whatsapp.R;
import com.example.gaurav.whatsapp.model.ContactModel;
import com.example.gaurav.whatsapp.model.StatusModel;

import java.util.ArrayList;

/**
 * Created by Nipun on 6/23/17.
 */

public class StatusFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View statusView = inflater.inflate(R.layout.status_layout, container, false);
        RecyclerView contactsRecyclerView = (RecyclerView) statusView.findViewById(R.id.statusList);
        ArrayList<StatusModel> statuses = new ArrayList<>();
        statuses.add(new StatusModel("Vivek", "Hello", "Friday", 0));
        statuses.add(new StatusModel("Recent Updates", "", "", 0, true));
        statuses.add(new StatusModel("Gaurav", "Hi", "Thursday", 0));
        statuses.add(new StatusModel("Viewed Updates", "", "", 0, true));
        statuses.add(new StatusModel("Nipun", "Hey", "Sunday", 0));


        StatusListAdapter adapter = new StatusListAdapter(statuses, getActivity());
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contactsRecyclerView.setAdapter(adapter);
        return statusView;
    }
}
