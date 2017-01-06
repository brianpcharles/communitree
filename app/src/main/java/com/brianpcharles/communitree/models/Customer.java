package com.brianpcharles.communitree.models;

import com.brianpcharles.communitree.models.Status;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Customer extends RealmObject {

    @PrimaryKey
    String customerID;

    String firstName;

    String lastName;

    String email;

    String password;

    Location billing;

    Location shipping;

    String phone;

    int isActive;

    String timezone;

    Date createdAt;

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Location getBilling() {
        return billing;
    }

    public void setBilling(Location billing) {
        this.billing = billing;
    }

    public Location getShipping() {
        return shipping;
    }

    public void setShipping(Location shipping) {
        this.shipping = shipping;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
