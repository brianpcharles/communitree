package com.brianpcharles.communitree.models;

import com.brianpcharles.communitree.models.Image;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Gallery extends RealmObject {

    @PrimaryKey
    String galleryID;

    String name;

    RealmList<Image> images;

    public String getGalleryID() {
        return galleryID;
    }

    public void setGalleryID(String galleryID) {
        this.galleryID = galleryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RealmList<Image> getImages() {
        return images;
    }

    public void setImages(RealmList<Image> images) {
        this.images = images;
    }
}
