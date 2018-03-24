package com.example.gaurav.webservices;

import android.content.SyncRequest;

/**
 * Created by gaurav on 6/30/2017.
 */

public class UserModel {
    private int id;
    private String firstName;
    private String lastnName;
    private String avtar;

    public UserModel(int id, String firstName, String lastnName, String avtar) {
        this.id = id;
        this.firstName = firstName;
        this.lastnName = lastnName;
        this.avtar = avtar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastnName() {
        return lastnName;
    }

    public void setLastnName(String lastnName) {
        this.lastnName = lastnName;
    }

    public String getAvtar() {
        return avtar;
    }

    public void setAvtar(String avtar) {
        this.avtar = avtar;
    }
}
