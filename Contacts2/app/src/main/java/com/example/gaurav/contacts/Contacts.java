package com.example.gaurav.contacts;

/**
 * Created by gaurav on 6/15/2017.
 */

public class Contacts {
    String name;
    int id;
    String number;
    boolean isSelected = false;

    public Contacts(String name, int id, String number) {
        this.name = name;
        this.id = id;
        this.number = number;

    }
}
