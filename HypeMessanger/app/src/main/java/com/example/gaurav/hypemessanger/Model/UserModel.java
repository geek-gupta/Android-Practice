package com.example.gaurav.hypemessanger.Model;

import java.util.ArrayList;

/**
 * Created by gaurav on 7/23/2017.
 */

public class UserModel {
    private String id;
    private String name;
    private String phone;
    private String email;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    private String token;
    ArrayList<GroupModel> groupModels;

    public UserModel(String id, String name, String phone, String email, String token, ArrayList<GroupModel> groupModels) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.token = token;
        this.groupModels = groupModels;
    }

    public UserModel(String id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public UserModel(String id, String name, String phone, String email, ArrayList<GroupModel> groupModels) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.groupModels = groupModels;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<GroupModel> getGroupModels() {
        return groupModels;
    }

    public void setGroupModels(ArrayList<GroupModel> groupModels) {
        this.groupModels = groupModels;
    }
}
