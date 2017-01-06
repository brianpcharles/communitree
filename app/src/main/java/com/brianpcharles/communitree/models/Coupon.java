package com.brianpcharles.communitree.models;

import com.brianpcharles.communitree.CTApp;
import com.brianpcharles.communitree.R;
import com.brianpcharles.communitree.models.Promotion;

import java.util.Date;

import io.realm.RealmModel;
import io.realm.RealmObject;

public class Coupon extends RealmObject {

    Promotion promotion;

    Boolean isPercent = true;

    int percent;

    double discount;

    String product;

    int downloads;

    int redemptions_per_customer;

    Date validDate;

    Date expiryDate;

    String terms;

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getRedemptions_per_customer() {
        return redemptions_per_customer;
    }

    public void setRedemptions_per_customer(int redemptions_per_customer) {
        this.redemptions_per_customer = redemptions_per_customer;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Boolean getPercent() {
        return isPercent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPercent(Boolean percent) {
        isPercent = percent;
    }

    public String getDiscountFormatted() {
        return isPercent ? getDiscountPercent() : getDiscountAmount();
    }

    public String getDiscountPercent() {
        return String.format(CTApp.getContext().getString(R.string.percent_off), percent);
    }

    public String getDiscountAmount() {
        return String.format(CTApp.getContext().getString(R.string.amount_off), discount);
    }

    public Boolean isCurrent() {
        return hasStarted() && !hasEnded();
    }

    public Boolean hasStarted() {
        Date now = new Date();
        return validDate.getTime() < now.getTime();
    }

    public Boolean hasEnded() {
        Date now = new Date();
        return expiryDate.getTime() > now.getTime();
    }


}
