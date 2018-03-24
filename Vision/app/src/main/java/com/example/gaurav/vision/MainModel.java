package com.example.gaurav.vision;

import android.view.View;

/**
 * Created by gaurav on 7/11/2017.
 */

public class MainModel {
    private String name;

    public MainModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
