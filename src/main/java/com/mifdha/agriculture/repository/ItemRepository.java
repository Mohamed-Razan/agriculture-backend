package com.mifdha.agriculture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mifdha.agriculture.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
