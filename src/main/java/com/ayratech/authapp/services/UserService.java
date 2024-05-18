package com.ayratech.authapp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayratech.authapp.models.UserDetailsModel;
import com.ayratech.authapp.repositories.UserRepository;

@Service
public class UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;
	
	public UserDetailsModel getUserData() throws Exception {

    	logger.info("Executing getUserData under UserService...");
    	
    	try {

    		UserDetailsModel userDetailsModel =  userRepository.findByuid(AuthService.uid);
    		
    		return userDetailsModel;
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in getUserData under UserService...");
			
		}
    }
	
}