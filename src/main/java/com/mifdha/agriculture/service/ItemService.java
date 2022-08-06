package com.mifdha.agriculture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mifdha.agriculture.model.Item;
import com.mifdha.agriculture.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repository;
	
	@Autowired
	private CategoryService categoryService;
	
	public Item createItem(String name, String unit, int categoryId) {
		
		Item item = new Item(name, unit, categoryService.getCategoryById(categoryId));
		
		return repository.save(item);
	}
	
	public Item getItemById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Item> getAllItem(){
		return repository.findAll();
	}
	
	public Item updateItem(int id, String name, String unit, int categoryId) {
		Item newItem = getItemById(id);
		
		if(newItem != null) {
			newItem.setId(id);
			newItem.setName(name);
			newItem.setUnit(unit);
			newItem.setCategory(categoryService.getCategoryById(categoryId));
			repository.save(newItem);
			return newItem;
		}
		
		return null;
	}
	
	public void deleteItem(int id) {
		repository.deleteById(id);
	}
}
