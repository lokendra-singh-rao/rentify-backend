package com.ayratech.authapp.models;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(value = Include.NON_NULL)
@Document("PropertyDetailsModel")
public class PropertyDetailsModel {
	@Id
	private String id;
	private String sellerId;
    private float area;
    private String place;
    private int bedrooms;
    private int bathrooms;
    private String nearbyPlaces;
    private float rent;
    private Instant createdAt;
}
