package com.codingblocks.whatsapp.Status;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.model.StatusModel;

import java.util.ArrayList;

/**
 * Created by Nipun on 6/23/17.
 */

public class StatusFragment extends Fragment {
    RecyclerView contactsRecyclerView;
    ArrayList<StatusModel> statuses;
    StatusListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View statusView = inflater.inflate(R.layout.status_fragment_layout, container, false);
        contactsRecyclerView = (RecyclerView) statusView.findViewById(R.id.statusList);
        statuses = new ArrayList<>();
        statuses.add(new StatusModel("Vivek", "Hello", "Friday", 0));
        statuses.add(new StatusModel("Recent Updates", "", "", 0, true));
        statuses.add(new StatusModel("Gaurav", "Hi", "Thursday", 0));
        statuses.add(new StatusModel("Viewed Updates", "", "", 0, true));
        statuses.add(new StatusModel("Nipun", "Hey", "Sunday", 0));


        adapter = new StatusListAdapter(statuses, getActivity());
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contactsRecyclerView.setAdapter(adapter);
        return statusView;
    }
}
