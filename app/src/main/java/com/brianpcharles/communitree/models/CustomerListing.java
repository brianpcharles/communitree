package com.brianpcharles.communitree.models;

import com.brianpcharles.communitree.models.Listing;
import com.brianpcharles.communitree.models.Customer;

import java.util.Date;

import io.realm.RealmObject;

public class CustomerListing extends RealmObject {

    Customer customer;

    Listing listing;

    Date createdAt;

}
