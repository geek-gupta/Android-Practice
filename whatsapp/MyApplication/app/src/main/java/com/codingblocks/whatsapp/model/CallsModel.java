package com.codingblocks.whatsapp.model;

import android.widget.ImageView;

/**
 * Created by gaurav on 6/24/2017.
 */

public class CallsModel {
    String name;
    String recentCallStatus;


    public CallsModel(String name, String recentCallStatus) {
        this.name = name;
        this.recentCallStatus = recentCallStatus;
    }

    public String getName() {
        return name;
    }

    public String getRecentCallStatus() {
        return recentCallStatus;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setRecentCallStatus(String recentCallStatus) {
        this.recentCallStatus = recentCallStatus;
    }




}
