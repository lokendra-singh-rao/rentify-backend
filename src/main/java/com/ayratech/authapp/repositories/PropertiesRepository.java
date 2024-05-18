package com.ayratech.authapp.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ayratech.authapp.models.PropertyDetailsModel;

@Repository
public interface PropertiesRepository extends MongoRepository<PropertyDetailsModel, String>{
	
	 List<PropertyDetailsModel> findBySellerId(String sellerId);
}
