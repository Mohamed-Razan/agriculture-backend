package com.mifdha.agriculture.model;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class AdvertisementItem {

	@EmbeddedId
	private AdvertisementItemKey id;
	
	@JsonIgnore
	@ManyToOne
	@MapsId("AdvertisementId")
    @JoinColumn(name = "advertisement_id")
	private Advertisement ad;
	
	@ManyToOne
	@MapsId("itemId")
    @JoinColumn(name = "item_id")
	private Item item;
	
	private int quantity;
	private double price;
	
	public AdvertisementItem(Advertisement ad, Item item, int quantity, double price) {
		super();
		this.id = new AdvertisementItemKey(ad.getId(), item.getId());
		this.ad = ad;
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}

	public AdvertisementItem() {
		super();
	}

	public AdvertisementItemKey getId() {
		return id;
	}

	public void setId(AdvertisementItemKey id) {
		this.id = id;
	}

	public Advertisement getAd() {
		return ad;
	}

	public void setAd(Advertisement ad) {
		this.ad = ad;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}
