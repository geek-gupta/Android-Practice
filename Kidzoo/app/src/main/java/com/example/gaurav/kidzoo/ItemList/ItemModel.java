package com.example.gaurav.kidzoo.ItemList;

import java.security.PrivateKey;

/**
 * Created by gaurav on 8/20/2017.
 */

public class ItemModel {
    private String name;
    private int imgsrc;

    public ItemModel(String name, int imgsrc) {
        this.name = name;
        this.imgsrc = imgsrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(int imgsrc) {
        this.imgsrc = imgsrc;
    }
}
