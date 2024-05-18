package com.ayratech.authapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ayratech.authapp.models.UserDetailsModel;
import com.ayratech.authapp.services.AuthService;
import com.ayratech.authapp.services.UserService;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	AuthService authService;
	
	@Autowired
	UserService userService;
    
    /**
	 * return user details document
	 * 
	 * @param adminDetailsModel 
	 * @return adminDetailsModel
	 * @throws Exception 
	 */
    @QueryMapping("getUserData")
    public UserDetailsModel getUserData() throws Exception {

    	logger.info("Executing getUserData under AuthController...");
    	
    	if(!authService.isUserAuthorised())
    		throw new IllegalAccessError("Unauthenticated user");
    	
    	try {

    		return userService.getUserData();
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in getUserData under AuthController...");
			
		}
    }

}
