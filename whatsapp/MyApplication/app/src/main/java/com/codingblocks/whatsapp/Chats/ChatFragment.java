package com.codingblocks.whatsapp.Chats;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingblocks.whatsapp.R;
import com.codingblocks.whatsapp.model.ChatModel;

import java.util.ArrayList;

/**
 * Created by Nipun on 6/23/17.
 */

public class ChatFragment extends Fragment {
    RecyclerView chatContactsRecyclerView;
    ChatsListAdapter chatsListAdapter;
    ArrayList<ChatModel> chatContacts;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View chatView = inflater.inflate(R.layout.chat_fragment_layout, container, false);
        chatContactsRecyclerView = (RecyclerView) chatView.findViewById(R.id.chatsList);
        chatContacts = new ArrayList<>();
        chatContacts.add(new ChatModel("Vivek", "Hello", "Friday", R.drawable.call_logo));
        chatContacts.add(new ChatModel("Gaurav", "Hi", "Thursday", R.drawable.call));
        chatContacts.add(new ChatModel("Nipun", "Hey", "Sunday", R.drawable.nipun));


        chatsListAdapter = new ChatsListAdapter(chatContacts, getActivity());
        chatContactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        chatContactsRecyclerView.setAdapter(chatsListAdapter);
        return chatView;
    }
}
