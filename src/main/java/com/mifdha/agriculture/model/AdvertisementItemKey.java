package com.mifdha.agriculture.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AdvertisementItemKey implements Serializable {

	@Column(name = "advertisement_id")
	private int advertisementId;
	@Column(name = "item_id")
	private int itemId;
	
	public AdvertisementItemKey(int advertisementId, int itemId) {
		super();
		this.advertisementId = advertisementId;
		this.itemId = itemId;
	}

	public AdvertisementItemKey() {
		super();
	}

	public int getAdvertisementId() {
		return advertisementId;
	}

	public void setAdvertisementId(int advertisementId) {
		this.advertisementId = advertisementId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + advertisementId;
		result = prime * result + itemId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdvertisementItemKey other = (AdvertisementItemKey) obj;
		if (advertisementId != other.advertisementId)
			return false;
		if (itemId != other.itemId)
			return false;
		return true;
	}
	
	
}
