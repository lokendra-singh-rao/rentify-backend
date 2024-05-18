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
@Document("UserDetails")
public class UserDetailsModel {
	@Id
	private String id;
	private String uid;
    private String fullname;
    private String email;
    private String phone;
    private Role role;
    private Instant lastLogin;
    private Instant createdAt;
    
    public static enum Role {
    	SELLER, BUYER
    }
}