package com.example.gaurav.apkextractor.apkinfo;

import android.graphics.drawable.Drawable;

/**
 * Created by gaurav on 9/16/2017.
 */

public class ApkListModel {

    private String name;
    private String filePath;
    private Drawable iconPath;
    private String packageName;
    private String versionName;
    private String versionCode;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public ApkListModel(String name,
                        String filePath,
                        Drawable iconPath,
                        String packageName,
                        String versionName,
                        String versionCode) {
        this.name = name;
        this.filePath = filePath;
        this.iconPath = iconPath;
        this.packageName = packageName;
        this.versionName = versionName;
        this.versionCode = versionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Drawable getIconPath() {
        return iconPath;
    }

    public void setIconPath(Drawable iconPath) {
        this.iconPath = iconPath;
    }
}


