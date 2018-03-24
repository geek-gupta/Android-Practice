package com.example.gaurav.listview;

import android.widget.ImageButton;

/**
 * Created by gaurav on 6/10/2017.
 */

public class Contacts {
    String name;
    int id;
    int number;
    boolean isSelected = false;

    public Contacts(String name, int id, int number) {
        this.name = name;
        this.id = id;
        this.number = number;

    }

}
