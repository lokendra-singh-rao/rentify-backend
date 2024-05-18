package com.ayratech.authapp.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ayratech.authapp.models.PropertyDetailsModel;
import com.ayratech.authapp.services.AuthService;
import com.ayratech.authapp.services.SellerService;

@Controller
public class SellerController {

	private static final Logger logger = LoggerFactory.getLogger(SellerController.class);

	@Autowired
	AuthService authService;
	
	@Autowired
	SellerService sellerService;
    
    /**
	 * add property for seller
	 * 
	 * @param propertyDetailsModel 
	 * @return List<PropertyDetailsModel>
	 * @throws Exception 
	 */
    @MutationMapping("addProperty")
    public List<PropertyDetailsModel> addProperty(@Argument("propertyDetailsModel") PropertyDetailsModel propertyDetailsModel) throws Exception {

    	logger.info("Executing addProperty under SellerController...");
    	
    	if(!authService.isUserAuthorised())
    		throw new IllegalAccessError("Unauthenticated user");
    	
    	if(propertyDetailsModel.getArea() <= 0
    			|| propertyDetailsModel.getPlace().isEmpty() 
    			|| propertyDetailsModel.getBedrooms() <= 0 
    			|| propertyDetailsModel.getBathrooms() <= 0 
    			|| propertyDetailsModel.getNearbyPlaces().isEmpty()
    			|| propertyDetailsModel.getRent() <= 0) {
    		throw new Exception("Property details should not be empty");
    	}
    	
    	try {

    		return sellerService.addProperty(propertyDetailsModel);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in addProperty under SellerController...");
			
		}
    }

    /**
	 * return all properties of seller
	 * 
	 * @return List<PropertyDetailsModel>
	 * @throws Exception 
	 */
    @QueryMapping("getSellerProperties")
    public List<PropertyDetailsModel> getSellerProperties() throws Exception {

    	logger.info("Executing getSellerProperties under SellerController...");
    	
    	if(!authService.isUserAuthorised())
    		throw new IllegalAccessError("Unauthenticated user");
    	
    	try {

    		return sellerService.getSellerProperties();
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in getSellerProperties under SellerController...");
			
		}
    }
    
    /**
	 * delete property for seller
	 * 
	 * @param id 
	 * @return List<PropertyDetailsModel>
	 * @throws Exception
	 */
    @MutationMapping("deleteProperty")
    public List<PropertyDetailsModel> deleteProperty(@Argument("id") String id) throws Exception {

    	logger.info("Executing deleteProperty under SellerController...");
    	
    	if(!authService.isUserAuthorised())
    		throw new IllegalAccessError("Unauthenticated user");
    	
    	if(id.isEmpty()) {
    		throw new Exception("id should not be empty");
    	}
    	
    	try {

    		return sellerService.deleteProperty(id);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in deleteProperty under SellerController...");
			
		}
    }
}
