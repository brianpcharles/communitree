package com.brianpcharles.communitree.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Image extends RealmObject {

    @PrimaryKey
    String imageID;

    String name;

    String url;

    String title;

    String alt;

    int width;

    int height;

    int crop_x;

    int crop_y;

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getCrop_x() {
        return crop_x;
    }

    public void setCrop_x(int crop_x) {
        this.crop_x = crop_x;
    }

    public int getCrop_y() {
        return crop_y;
    }

    public void setCrop_y(int crop_y) {
        this.crop_y = crop_y;
    }
}
