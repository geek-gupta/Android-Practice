package com.example.gaurav.hypemessanger.Model;

/**
 * Created by gaurav on 7/23/2017.
 */

public class AuthenticationModel {

    private String userName;
    private String password;
    private String id;

    public AuthenticationModel(String userName, String password, String id) {
        this.userName = userName;
        this.password = password;
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
