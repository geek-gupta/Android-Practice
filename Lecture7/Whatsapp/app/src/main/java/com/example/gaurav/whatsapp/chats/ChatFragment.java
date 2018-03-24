package com.example.gaurav.whatsapp.chats;

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

import java.util.ArrayList;

/**
 * Created by gaurav on 6/23/2017.
 */

public class ChatFragment extends Fragment {
    RecyclerView contactsRecyclerView;
    ChatsListAdapter chatsListAdapter;
    ArrayList<ContactModel> contacts;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_fragment_layout,container,false);
        contactsRecyclerView =(RecyclerView) view.findViewById(R.id.chatsList);
        contacts = new ArrayList<>();
        contacts.add(new ContactModel("Vivek","Hello Vivek","saturday",0));
        contacts.add(new ContactModel("Gaurav","Hello Gaurav","Friday",1));
        contacts.add(new ContactModel("Nipun","Hello Nipun","Thursday",2));

        chatsListAdapter = new ChatsListAdapter(getActivity(),contacts);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        contactsRecyclerView.setAdapter(chatsListAdapter);
        return view;
    }
}
