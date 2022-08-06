package com.mifdha.agriculture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mifdha.agriculture.model.Category;
import com.mifdha.agriculture.service.CategoryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController {

	@Autowired
	private CategoryService service;
	
	@PostMapping("/create-category")
	public Category createCategory(@RequestBody Category category) {
		return service.createCategory(category);
	}
	
	@GetMapping("/get-category/{id}")
	public Category getCategoryById(@PathVariable int id) {
		return service.getCategoryById(id);
	}
	
	@GetMapping("/get-all-category")
	public List<Category> getAllCategory(){
		return service.getAllCategory();
	}
	@PutMapping("/update-category")
	public Category updateCategory(@RequestBody Category category) {
		return service.updateCategory(category);
	}
	
	@DeleteMapping("/delete-category/{id}")
	public void deleteCategory(@PathVariable int id) {	
		service.deleteCategory(id);
	}
}
