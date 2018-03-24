package com.example.gaurav.whatsapp.model;

import java.util.UUID;

/**
 * Created by gaurav on 6/23/2017.
 */

public class ContactModel {
    private String name;
    private String recent_messeage;
    private String lastseen;
    private String id;
    private int imageId;

    public ContactModel(String name, String recent_messeage, String lastseen, int imageId) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.recent_messeage = recent_messeage;
        this.lastseen = lastseen;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getRecent_messeage() {
        return recent_messeage;
    }

    public String getLastseen() {
        return lastseen;
    }

    public String getId() {
        return id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecent_messeage(String recent_messeage) {
        this.recent_messeage = recent_messeage;
    }

    public void setLastseen(String lastseen) {
        this.lastseen = lastseen;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}
