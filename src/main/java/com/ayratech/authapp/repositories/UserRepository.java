package com.ayratech.authapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ayratech.authapp.models.UserDetailsModel;

@Repository
public interface UserRepository extends MongoRepository<UserDetailsModel, String>{
	
	UserDetailsModel findByuid(String uid);
}
