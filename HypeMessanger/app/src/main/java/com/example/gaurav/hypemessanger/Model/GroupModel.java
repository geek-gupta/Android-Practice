package com.example.gaurav.hypemessanger.Model;

/**
 * Created by gaurav on 7/23/2017.
 */

public class GroupModel {
    private String id;
    private String groupName;
    private String memberCount;

    public GroupModel(String id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(String memberCount) {
        this.memberCount = memberCount;
    }
}
