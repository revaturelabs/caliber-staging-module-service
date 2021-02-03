package com.revature.backend.config;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.revature.backend.security.FirebaseAuthenticationManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;

/**
 * @author Jay Monari
 */
@Configuration
@Profile("firebase")
public class FirebaseConfig {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final FirebaseAuth firebaseAuth;

  public FirebaseConfig(FirebaseAuth firebaseAuth) {
    this.firebaseAuth = firebaseAuth;
  }

  public FirebaseConfig() {
    try (FileInputStream serviceAccount = new FileInputStream(
        System.getenv("GOOGLE_APPLICATION_CREDENTIALS"))) {
      FirebaseOptions defaultOptions = FirebaseOptions.builder()
          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
          .build();
      this.firebaseAuth = FirebaseAuth.getInstance(FirebaseApp.initializeApp(defaultOptions));
      logger.info("Successfully initialized Firebase and FirebaseAuth!");
    } catch (IOException e) {
      logger.error("Failed to instantiate Firebase", e);
      throw new RuntimeException(e);
    }
  }

  @Primary
  @Bean
  @Profile("firebase")
  public AuthenticationManager firebaseAuthenticationManager() {
    return new FirebaseAuthenticationManager(this.firebaseAuth);
  }
}
