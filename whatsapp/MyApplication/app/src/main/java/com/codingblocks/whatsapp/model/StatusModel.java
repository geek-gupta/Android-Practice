package com.codingblocks.whatsapp.model;

import java.util.UUID;

/**
 * Created by Nipun on 6/23/17.
 */

public class StatusModel {
    private String name;
    private String recentMessage;
    private String lastSeen;
    private String id;
    private int imageId;
    boolean isHeading;


    public StatusModel(String name,
                        String recentMessage, String lastSeen,
                        int imageId) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.recentMessage = recentMessage;
        this.lastSeen = lastSeen;
        this.imageId = imageId;
    }

    public StatusModel(String name,
                        String recentMessage, String lastSeen,
                        int imageId, boolean isHeading) {
        id = UUID.randomUUID().toString();
        this.name = name;
        this.recentMessage = recentMessage;
        this.lastSeen = lastSeen;
        this.imageId = imageId;
        this.isHeading = isHeading;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecentMessage() {
        return recentMessage;
    }

    public void setRecentMessage(String recentMessage) {
        this.recentMessage = recentMessage;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isHeading() {
        return isHeading;
    }

    public void setHeading(boolean heading) {
        isHeading = heading;
    }
}
