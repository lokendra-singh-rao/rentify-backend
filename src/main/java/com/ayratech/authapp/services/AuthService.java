package com.ayratech.authapp.services;

import java.time.Instant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayratech.authapp.models.UserDetailsModel;
import com.ayratech.authapp.repositories.UserRepository;
import com.google.firebase.auth.FirebaseToken;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AuthService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthService.class);
	
	public static String uid;
	public static String email;
	public static String token;
	
	@Autowired
	FirebaseService firebaseService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	HttpServletRequest httpServletRequest;
	
	public String signUpUser(UserDetailsModel userDetailsModel) throws Exception {

    	logger.info("Executing signUpUser under AuthService...");

    	try {
    		
    		AuthService.token = httpServletRequest.getHeader("FirebaseToken");
    		
    		FirebaseToken decodedToken = firebaseService.getDecodedUser(token);
    		
    		UserDetailsModel userDetailsModelBuilder = UserDetailsModel.builder()
    				.uid(decodedToken.getUid())
    				.fullname(userDetailsModel.getFullname())
    				.email(userDetailsModel.getEmail())
    				.phone(userDetailsModel.getPhone())
    				.role(userDetailsModel.getRole())
    				.createdAt(Instant.now())
    				.build();
    		
    		userRepository.save(userDetailsModelBuilder);
    		
    		return "Signed up Successfully";
    		    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in signUpUser under AuthService...");
			
		}
    }
	
	public String signInUser() throws Exception {

    	logger.info("Executing signInUser under AuthService...");
    	
    	try {

    		UserDetailsModel userDetailsModel =  userRepository.findByuid(AuthService.uid);
    		userDetailsModel.setLastLogin(Instant.now());
    		userRepository.save(userDetailsModel);
    		
    		return userDetailsModel.getRole().toString();
    		
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in signInUser under AuthService...");
			
		}
    }
	
	public boolean isUserAuthorised() throws Exception {
		
		logger.info("Executing isUserAuthorised under AuthService...");
		
		try {
			
			AuthService.token = httpServletRequest.getHeader("FirebaseToken");
			
			FirebaseToken decodedToken = firebaseService.getDecodedUser(token);
			
			if(decodedToken.isEmailVerified()) {
				AuthService.uid = decodedToken.getUid();
				AuthService.email = decodedToken.getUid();
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			
			logger.info(e.toString());
			throw new Exception("Exception occured in isUserAuthorised under AuthService...");
			
		}
		
	}
	
}