package com.mifdha.agriculture.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import com.mifdha.agriculture.model.Advertisement;
import com.mifdha.agriculture.model.AdvertisementItem;
import com.mifdha.agriculture.model.AdvertisementItemKey;
import com.mifdha.agriculture.repository.AdvertisementItemRepository;
import com.mifdha.agriculture.repository.AdvertisementRepository;

@Service
public class AdvertisementService {

	@Autowired
	private AdvertisementItemRepository advertisementItemRepository;
	
	@Autowired
	private AdvertisementRepository advertisementrepository;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private SellerService sellerService;
	
	public Advertisement createAdvertisement(int sellerId, String title, String description, int itemId[], int quantity[], 
			double price[], MultipartFile file) {
		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
			return null;
		}
		
		try {
			List<AdvertisementItem> adItems = new ArrayList<AdvertisementItem>();
			
			Advertisement ad = new Advertisement(title, description, sellerService.getSellerById(sellerId), file.getBytes());
			advertisementrepository.save(ad);
			
			for(int i = 0; i < itemId.length; i++) {
				AdvertisementItem adItem = new AdvertisementItem(ad, itemService.getItemById(itemId[i]), quantity[i], price[i]);
				adItems.add(adItem);
			}
			
			advertisementItemRepository.saveAll(adItems);
			
			return ad;
		}
		
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public Advertisement getAdvertisementById(int id) {
		return advertisementrepository.findById(id).orElse(null);
	}
	
	public List<Advertisement> getAllAdvertisements(){
		boolean isValid;
		PhoneNumber number;
		PhoneNumberUtil util = PhoneNumberUtil.getInstance();

		String numStr = "8814";
		for (String r : util.getSupportedRegions())
		{
		    try {
		        // check if it's a possible number
		        isValid = util.isPossibleNumber(numStr, r);
		        if (isValid)
		        {
		            number = util.parse(numStr, r);

		            // check if it's a valid number for the given region
		            isValid = util.isValidNumberForRegion(number, r);
		            if (isValid)
		                System.out.println(r + ": " + number.getCountryCode() + ", " + number.getNationalNumber());
		        }
		    } catch (NumberParseException e)
		    {
		        e.printStackTrace();
		    }
		}
		return advertisementrepository.findAll();
	}
	
	public Advertisement updateAdvertisement(int adId, int sellerId, String title, String description, int itemId[], int quantity[], double price[], MultipartFile file) {
	
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if (fileName.contains("..")) {
			System.out.println("not a a valid file");
			return null;
		}
		
		Advertisement newAdvertisement = getAdvertisementById(adId);
		
		if(newAdvertisement != null) {
			newAdvertisement.setId(adId);
			newAdvertisement.setTitle(title);
			newAdvertisement.setDescription(description);
			newAdvertisement.setSeller(sellerService.getSellerById(sellerId));
			try {
				newAdvertisement.setFile(file.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			advertisementrepository.save(newAdvertisement);
			
			int i; 
			
			List<AdvertisementItem> advertisementItems = advertisementItemRepository.findByAd(newAdvertisement);
			
			for(i = 0; i < advertisementItems.size(); i++) {
				System.out.println(advertisementItems.get(i));
				advertisementItemRepository.delete(advertisementItems.get(i));
			}
			
			List<AdvertisementItem> adItems = new ArrayList<AdvertisementItem>();
			
			for(i = 0; i < itemId.length; i++) {
				AdvertisementItem adItem = new AdvertisementItem(newAdvertisement, itemService.getItemById(itemId[i]), quantity[i], price[i]);
				adItems.add(adItem);
			}
			
			advertisementItemRepository.saveAll(adItems);
			
			return newAdvertisement;
		}
		return null;
	}
	
	public void deleteAdvertisement(int id) {
		advertisementrepository.deleteById(id);
	}
}
