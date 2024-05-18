package com.ayratech.authapp.configurations;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    FirebaseApp firebaseApp() throws IOException {
    	
        FileInputStream serviceAccount = new FileInputStream("C:\\Users\\Loken\\Downloads\\firebase-auth-app-backend-main\\firebase-auth-app-backend-main\\src\\main\\resources\\serviceAccountKey.json");
        
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        return FirebaseApp.initializeApp(options);
        
    }
}

