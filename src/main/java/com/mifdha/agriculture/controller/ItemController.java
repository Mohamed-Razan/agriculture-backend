package com.mifdha.agriculture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mifdha.agriculture.model.Item;
import com.mifdha.agriculture.service.ItemService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ItemController {

	@Autowired
	private ItemService service;
	
	@PostMapping("/create-item")
	public Item createItem(@RequestParam String name, @RequestParam String unit, @RequestParam int categoryId) {
		return service.createItem(name, unit, categoryId);
	}
	
	@GetMapping("/get-all-item")
	public List<Item> getAllItem(){
		return service.getAllItem();
	}
	
	@GetMapping("/get-item-by-id/{id}")
	public Item getItemById(@PathVariable int id) {
		return service.getItemById(id);
	}
	
	@PutMapping("/update-item")
	public Item updateItem(@RequestParam int id, @RequestParam String name, @RequestParam String unit, @RequestParam int categoryId) {
		return service.updateItem(id, name, unit, categoryId);
	}
	
	@DeleteMapping("/delete-item/{id}")
	public void deleteItem(@PathVariable int id) {
		service.deleteItem(id);
	}
}
