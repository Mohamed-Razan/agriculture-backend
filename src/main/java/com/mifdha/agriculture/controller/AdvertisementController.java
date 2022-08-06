package com.mifdha.agriculture.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mifdha.agriculture.model.Advertisement;
import com.mifdha.agriculture.service.AdvertisementService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdvertisementController {

	@Autowired
	private AdvertisementService service;
	
	@PostMapping("/create-advertisement")
	public Advertisement createAdvertisement(@RequestParam int sellerId, @RequestParam String title, @RequestParam String description, 
			@RequestParam int itemId[], @RequestParam int quantity[], @RequestParam double price[], @RequestParam MultipartFile file) {
		return service.createAdvertisement(sellerId, title, description, itemId, quantity, price, file);
	}
	
	@GetMapping("/get-ad/{id}")
	public Advertisement getAdvertisementById(@PathVariable int id) {
		return service.getAdvertisementById(id);
	}
	
	@GetMapping("/get-all-ad")
	public List<Advertisement> getAllAdvertisements(){
		return service.getAllAdvertisements();
	}
	
	@PutMapping("/update-ad")
	public Advertisement updateAdvertisement(@RequestParam int adId, @RequestParam int sellerId, @RequestParam String title, @RequestParam String description, 
			@RequestParam int itemId[], @RequestParam int quantity[], @RequestParam double price[], @RequestParam MultipartFile file) {
		return service.updateAdvertisement(adId, sellerId, title, description, itemId, quantity, price, file);
	}
	
	@DeleteMapping("/delete-ad/{id}")
	public void deleteAdvertisement(@PathVariable int id) {
		service.deleteAdvertisement(id);
	}
}
