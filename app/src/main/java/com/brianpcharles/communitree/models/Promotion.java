package com.brianpcharles.communitree.models;

import com.brianpcharles.communitree.models.Gallery;
import com.brianpcharles.communitree.models.Listing;
import com.brianpcharles.communitree.models.Status;
import com.brianpcharles.communitree.models.User;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Promotion extends RealmObject {

	@PrimaryKey
	String promoID;

	//Relationship to listing customer..
	Listing listing;

	//Relationship to images
	Gallery gallery;

	String name;

	String title;

	String description;

	String url;

	String type;

	int isActive;

	Date startDate;

	Date endDate;

	//Created by
	User createdBy;

	//Created at.
	Date createdAt;

	public String getPromoID() {
		return promoID;
	}

	public void setPromoID(String promoID) {
		this.promoID = promoID;
	}

	public Listing getListing() {
		return listing;
	}

	public void setListing(Listing listing) {
		this.listing = listing;
	}

	public Gallery getGallery() {
		return gallery;
	}

	public void setGallery(Gallery gallery) {
		this.gallery = gallery;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
