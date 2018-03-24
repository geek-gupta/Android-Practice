package com.example.gaurav.hypemessanger.Model;

/**
 * Created by gaurav on 7/30/2017.
 */

public class MessageModel {
    private String senderName;
    private String timestamp;
    private  String data;

    public MessageModel(String senderName, String timestamp, String data) {
        this.senderName = senderName;
        this.timestamp = timestamp;
        this.data = data;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
