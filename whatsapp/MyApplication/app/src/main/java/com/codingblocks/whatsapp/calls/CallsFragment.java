package com.codingblocks.whatsapp.calls;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.model.CallsModel;

import java.util.ArrayList;

/**
 * Created by Nipun on 6/23/17.
 */

public class CallsFragment extends Fragment {

    RecyclerView callsListRecyclerView;
    ArrayList<CallsModel> calls;
    CallsListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View callsView = inflater.inflate(R.layout.calls_fragment_layout, container, false);
        callsListRecyclerView = (RecyclerView) callsView.findViewById(R.id.callsList);
         calls = new ArrayList<>();
        calls.add(new CallsModel("Gaurav","10:00 am"));
        calls.add(new CallsModel("Saurav","11:23 am"));
        calls.add(new CallsModel("Nipun","12:00 pm"));
        calls.add(new CallsModel("Vivek","02:00 pm"));
        calls.add(new CallsModel("Anmol","01:00 Am"));

        adapter = new CallsListAdapter(calls,getActivity());
        callsListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        callsListRecyclerView.setAdapter(adapter);
        return callsView;
    }
}
