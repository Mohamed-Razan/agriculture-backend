package com.mifdha.agriculture.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Seller {

	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String contact;
	private String district;
	private String city;
	
	@JsonIgnore
	@OneToMany(mappedBy = "seller")
	private List<Advertisement> ads;

	public Seller(String fname, String lname, String email, String contact, String district, String city) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.contact = contact;
		this.district = district;
		this.city = city;
	}

	public Seller() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Advertisement> getAds() {
		return ads;
	}

	public void setAds(List<Advertisement> ads) {
		this.ads = ads;
	}
	
}
