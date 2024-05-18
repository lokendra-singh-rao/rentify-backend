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
import com.ayratech.authapp.models.SellerInfoModel;
import com.ayratech.authapp.services.AuthService;
import com.ayratech.authapp.services.BuyerService;

@Controller
public class BuyerController {

	private static final Logger logger = LoggerFactory.getLogger(BuyerController.class);

	@Autowired
	AuthService authService;
	
	@Autowired
	BuyerService buyerService;
	
    /**
	 * return all properties
	 * 
	 * @return List<PropertyDetailsModel>
	 * @throws Exception 
	 */
    @QueryMapping("getAllProperties")
    public List<PropertyDetailsModel> getAllProperties() throws Exception {

    	logger.info("Executing getAllProperties under BuyerController...");
    	
    	if(!authService.isUserAuthorised())
    		throw new IllegalAccessError("Unauthenticated user");
    	
    	try {

    		return buyerService.getAllProperties();
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in getAllProperties under BuyerController...");
			
		}
    }
    
    /**
	 * return all properties
	 * 
	 * @return SellerInfoModel
	 * @throws Exception 
	 */
    @MutationMapping("getSellerInfo")
    public SellerInfoModel getSellerInfo(@Argument("id") String id) throws Exception {

    	logger.info("Executing getSellerInfo under BuyerController...");
    	
    	if(!authService.isUserAuthorised())
    		throw new IllegalAccessError("Unauthenticated user");
    	
    	try {

    		return buyerService.getSellerInfo(id);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in getSellerInfo under BuyerController...");
			
		}
    }
}
