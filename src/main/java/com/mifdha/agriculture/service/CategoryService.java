package com.mifdha.agriculture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mifdha.agriculture.model.Category;
import com.mifdha.agriculture.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public Category createCategory(Category category) {
		return repository.save(category);
	}
	
	public Category getCategoryById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Category> getAllCategory() {
		return repository.findAll();
	}
	
	public Category updateCategory(Category category) {
		Category newCategory = getCategoryById(category.getId());
		
		newCategory.setId(category.getId());
		newCategory.setName(category.getName());
		
		repository.save(newCategory);
		
		return newCategory;
	}
	
	public void deleteCategory(int id) {
		repository.deleteById(id);
	}
}
