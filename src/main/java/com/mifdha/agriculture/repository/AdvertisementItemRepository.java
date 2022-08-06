package com.mifdha.agriculture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mifdha.agriculture.model.Advertisement;
import com.mifdha.agriculture.model.AdvertisementItem;
import com.mifdha.agriculture.model.AdvertisementItemKey;

public interface AdvertisementItemRepository extends JpaRepository<AdvertisementItem, AdvertisementItemKey> {

	public List<AdvertisementItem> findByAd(Advertisement advertisement);
}
