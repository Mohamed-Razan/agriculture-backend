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

import com.mifdha.agriculture.model.Seller;
import com.mifdha.agriculture.service.SellerService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SellerController {

	@Autowired
	private SellerService service;
	
	@PostMapping("/create-seller")
	public Seller createSeller(@RequestBody Seller seller) {
		return service.createSeller(seller);
	}
	
	@GetMapping("/get-all-seller")
	public List<Seller> getAllSeller(){
		return service.getAllSeller();
	}
	
	@GetMapping("/get-seller/{id}")
	public Seller getSellerById(@PathVariable int id) {
		return service.getSellerById(id);
	}
	
	@PutMapping("/update-seller")
	public Seller updateSeller(@RequestBody Seller seller) {
		return service.updateSeller(seller);
	}
	
	@DeleteMapping("/delete-seller/{id}")
	public void deleteSeller(@PathVariable int id) {
		service.deleteSeller(id);
	}
}
