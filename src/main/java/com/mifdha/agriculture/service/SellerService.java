package com.mifdha.agriculture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mifdha.agriculture.model.Seller;
import com.mifdha.agriculture.repository.SellerRepository;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	public Seller createSeller(Seller seller) {
		return repository.save(seller);
	}
	
	public List<Seller> getAllSeller(){
		return repository.findAll();
	}
	
	public Seller getSellerById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Seller updateSeller(Seller seller) {
		Seller newSeller = getSellerById(seller.getId());
		
		if(newSeller == null) {
			repository.save(seller);
		}
		
		else {
			newSeller.setId(seller.getId());
			newSeller.setFname(seller.getFname());
			newSeller.setLname(seller.getLname());
			newSeller.setDistrict(seller.getDistrict());
			newSeller.setCity(seller.getCity());
			newSeller.setEmail(seller.getEmail());
			newSeller.setContact(seller.getContact());
			repository.save(newSeller);
		}
		
		return newSeller;
	}
	
	public void deleteSeller(int id) {
		repository.deleteById(id);
	}
}
