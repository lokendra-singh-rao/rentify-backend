package com.ayratech.authapp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ayratech.authapp.models.UserDetailsModel;
import com.ayratech.authapp.services.AuthService;

@Controller
public class AuthController {

	private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

	@Autowired
	AuthService authService;
	
	/**
	 * creates user details document in database on sign up
	 *
	 * @param fullname, email 
	 * @return UserDetailsModel
	 * @throws Exception 
	 */
    @MutationMapping("signUpUser")
    public String signUpUser(@Argument("userDetailsModel") UserDetailsModel userDetailsModel) throws Exception {

    	logger.info("Executing signUpUser under AuthController...");
    	
    	try {

    		if(userDetailsModel.getFullname().isEmpty() || userDetailsModel.getEmail().isEmpty() || userDetailsModel.getPhone().isEmpty() || userDetailsModel.getRole().toString().isEmpty())
    			throw new IllegalArgumentException("Required fields cannot be empty");
    		
    		return authService.signUpUser(userDetailsModel);
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in signUpUser under AuthController...");
			
		}
    }
    
    /**
	 * return user details document for sign in authentication
	 * 
	 * @return UserDetailsModel
	 * @throws Exception 
	 */
    @QueryMapping("signInUser")
    public String signInUser() throws Exception {

    	logger.info("Executing signInUser under AuthController...");
    	
    	if(!authService.isUserAuthorised())
    		throw new IllegalAccessError("Unauthenticated user");
    	
    	try {

    		return authService.signInUser();
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in signInUser under AuthController...");
			
		}
    }

}
