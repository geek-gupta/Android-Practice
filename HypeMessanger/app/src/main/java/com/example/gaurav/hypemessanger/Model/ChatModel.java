package com.example.gaurav.hypemessanger.Model;

import android.support.annotation.NonNull;

/**
 * Created by gaurav on 8/29/2017.
 */

public class ChatModel
//        implements Comparable<ChatModel>
{

    private String chatMessage;
    private long timeStamp;
    private String token;
    private  int messageType;


    public ChatModel(String chatMessage, long timeStamp, String token, int messageType) {
        this.chatMessage = chatMessage;
        this.timeStamp = timeStamp;
        this.token = token;
        this.messageType = messageType;
    }

    public String getChatMessage() {
        return chatMessage;
    }

    public void setChatMessage(String chatMessage) {
        this.chatMessage = chatMessage;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

//    @Override
//    public int compareTo(@NonNull ChatModel other) {
//
//        return timeStamp>other.getTimeStamp()?1:0;
//    }
}
