package com.example.gaurav.hypemessanger.Model;

import com.example.gaurav.hypemessanger.enums.TransactionTypeEnum;
import com.example.gaurav.hypemessanger.enums.TypeEnum;

/**
 * Created by gaurav on 7/23/2017.
 */

public class DataModel {
    private TypeEnum typeEnum;
    private TransactionTypeEnum transactionTypeEnum;
    private String id;
    private String timeStamp;
    private String senderId;
    private String senderName;
    private String data;

    public DataModel(TypeEnum typeEnum, TransactionTypeEnum transactionTypeEnum,
                     String id, String timeStamp, String senderId,
                     String senderName, String data) {
        this.typeEnum = typeEnum;
        this.transactionTypeEnum = transactionTypeEnum;
        this.id = id;
        this.timeStamp = timeStamp;
        this.senderId = senderId;
        this.senderName = senderName;
        this.data = data;
    }

    public TypeEnum getTypeEnum() {
        return typeEnum;
    }

    public void setTypeEnum(TypeEnum typeEnum) {
        this.typeEnum = typeEnum;
    }

    public TransactionTypeEnum getTransactionTypeEnum() {
        return transactionTypeEnum;
    }

    public void setTransactionTypeEnum(TransactionTypeEnum transactionTypeEnum) {
        this.transactionTypeEnum = transactionTypeEnum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
