package com.brianpcharles.communitree.models;

import com.brianpcharles.communitree.models.Listing;
import com.brianpcharles.communitree.models.User;

import io.realm.RealmObject;

public class UserListing extends RealmObject {

    User user;

    Listing listing;

    Boolean isAdmin = false;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
