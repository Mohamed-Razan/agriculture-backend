package com.mifdha.agriculture.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String unit;

	@JsonIgnore
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	List<AdvertisementItem> adItem;

	@ManyToOne
	private Category category;

	public Item(String name, String unit, Category category) {
		super();
		this.name = name;
		this.unit = unit;
		this.category = category;
	}

	public Item() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AdvertisementItem> getAdItem() {
		return adItem;
	}

	public void setAdItem(List<AdvertisementItem> adItem) {
		this.adItem = adItem;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

}
