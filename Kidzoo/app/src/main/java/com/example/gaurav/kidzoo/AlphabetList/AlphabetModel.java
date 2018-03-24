package com.example.gaurav.kidzoo.AlphabetList;

/**
 * Created by gaurav on 8/20/2017.
 */

public class AlphabetModel {
    private int textImage;
    private int iconImage;
    private String name;

    public AlphabetModel(String name,int textImage, int iconImage) {
        this.name = name;
        this.textImage = textImage;
        this.iconImage = iconImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTextImage() {
        return textImage;
    }

    public void setTextImage(int textImage) {
        this.textImage = textImage;
    }

    public int getIconImage() {
        return iconImage;
    }

    public void setIconImage(int iconImage) {
        this.iconImage = iconImage;
    }
}
