package com.ayratech.authapp.services;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayratech.authapp.models.PropertyDetailsModel;
import com.ayratech.authapp.repositories.PropertiesRepository;

@Service
public class SellerService {
	
	private static final Logger logger = LoggerFactory.getLogger(SellerService.class);
	
	@Autowired
	PropertiesRepository sellerRepository;
	
	public List<PropertyDetailsModel> addProperty(PropertyDetailsModel propertyDetailsModel) throws Exception {

    	logger.info("Executing addProperty under SellerService...");
    	
    	try {

    		propertyDetailsModel.setSellerId(AuthService.uid);
    		propertyDetailsModel.setCreatedAt(Instant.now());
    		
    		sellerRepository.save(propertyDetailsModel);
    		
    		return sellerRepository.findBySellerId(AuthService.uid);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in addProperty under SellerService...");
			
		}
    }
	
	public List<PropertyDetailsModel> getSellerProperties() throws Exception {

    	logger.info("Executing addProperty under SellerService...");
    	
    	try {
    		
    		return sellerRepository.findBySellerId(AuthService.uid);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in addProperty under SellerService...");
			
		}
    }
	
	public List<PropertyDetailsModel> deleteProperty(String id) throws Exception {

    	logger.info("Executing deleteProperty under SellerService...");
    	
    	try {

    		PropertyDetailsModel model = sellerRepository.findById(id).get();
    		
    		if(!model.getSellerId().equals(AuthService.uid)) {
    			throw new Exception("Illegal access denied");
    		}
    		
    		sellerRepository.deleteById(id);
    		
    		return sellerRepository.findBySellerId(AuthService.uid);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in deleteProperty under SellerService...");
			
		}
    }
}