package com.mifdha.agriculture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mifdha.agriculture.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
