package com.brianpcharles.communitree.models;

import com.brianpcharles.communitree.models.Customer;
import com.brianpcharles.communitree.models.Promotion;

import java.util.Date;

import io.realm.RealmObject;

public class CustomerPromotion extends RealmObject {

    Customer customer;

    Promotion promotion;

    Date createdAt;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
