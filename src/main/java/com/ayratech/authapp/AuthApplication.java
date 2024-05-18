package com.ayratech.authapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "com.ayratech.authapp")
public class AuthApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(AuthApplication.class, args);
	}

}
