package com.ayratech.authapp.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayratech.authapp.models.PropertyDetailsModel;
import com.ayratech.authapp.models.SellerInfoModel;
import com.ayratech.authapp.models.UserDetailsModel;
import com.ayratech.authapp.repositories.PropertiesRepository;
import com.ayratech.authapp.repositories.UserRepository;

@Service
public class BuyerService {
	
	private static final Logger logger = LoggerFactory.getLogger(BuyerService.class);
	
	@Autowired
	PropertiesRepository propertiesRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public List<PropertyDetailsModel> getAllProperties() throws Exception {

    	logger.info("Executing addProperty under SellerService...");
    	
    	try {
    		
    		return propertiesRepository.findAll();
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in getAllProperties under BuyerService...");
			
		}
    }

	public SellerInfoModel getSellerInfo(String id) throws Exception {
		
		logger.info("Executing addProperty under SellerService...");
    	
    	try {
    		
    		UserDetailsModel userDetailsModel = userRepository.findByuid(id);
    		
    		SellerInfoModel sellerInfoModel = SellerInfoModel.builder()
    				.fullname(userDetailsModel.getFullname())
    				.email(userDetailsModel.getEmail())
    				.phone(userDetailsModel.getPhone())
    				.build();
    		
    		return sellerInfoModel;
    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in getAllProperties under BuyerService...");
			
		}
	}
}