package com.brianpcharles.communitree.models;

import java.util.Date;

import io.realm.RealmModel;
import io.realm.RealmObject;

public class Event extends RealmObject {

    Promotion promotion;

    Date eventStartDate;

    Date eventEndDate;

    Double admission;

    Boolean isPublic;

    Location location;

    String terms;

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Date getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public Date getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public void setAdmission(Double admission) {
        this.admission = admission;
    }

    public Double getAdmission() {
        return admission;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public String getAdmissionFormatted() {
        return "$" + admission;
    }

    public Boolean hasStarted() {
        Date now = new Date();
        return now.getTime() > eventStartDate.getTime();
    }

    public Boolean hasEnded() {
        Date now = new Date();
        return now.getTime() < eventEndDate.getTime();
    }
}
