package com.mifdha.agriculture.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Advertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	
	@Lob
	private byte[] file;
	
	@ManyToOne
	private Seller seller;
	
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "ad")
	List<AdvertisementItem> adItem;

	public Advertisement(String title, String description, Seller seller, byte[] file) {
		super();
		this.title = title;
		this.description = description;
		this.seller = seller;
		this.file = file;
	}

	public Advertisement() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public List<AdvertisementItem> getAdItem() {
		return adItem;
	}

	public void setAdItem(List<AdvertisementItem> adItem) {
		this.adItem = adItem;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	
	
	
	
}
