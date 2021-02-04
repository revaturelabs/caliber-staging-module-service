package com.revature.backend.testing.security;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.firebase.auth.FirebaseAuth;
import com.revature.backend.security.FirebaseAuthenticationManager;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FirebaseAuthenticationManagerTest {

  @InjectMocks
  private FirebaseAuthenticationManager fireAuthMan;
  @Mock
  FirebaseAuth mockFireAuth;

  @BeforeEach
  public void before(){

  }

  @AfterEach
  public void after(){

  }
  @Test
  public void notNullTest(){
    fireAuthMan=new FirebaseAuthenticationManager(mockFireAuth);
    assertThat(fireAuthMan).isNotNull();
  }
  
}
