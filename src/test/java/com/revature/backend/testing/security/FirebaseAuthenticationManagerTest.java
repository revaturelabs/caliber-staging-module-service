package com.revature.backend.testing.security;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseToken;
import com.revature.backend.security.FirebaseAuthenticationManager;
import com.revature.backend.security.UnauthenticatedManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;

@SpringBootTest
public class FirebaseAuthenticationManagerTest {

  @InjectMocks
  private FirebaseAuthenticationManager fireAuthMan;
  @Mock
  FirebaseAuth mockFireAuth;

  private Authentication mockVerifiedAuth;
  private Authentication mockUnverifiedAuth;
  private Authentication mockNullCredAuth;
  private String credentials;
  private FirebaseToken token;

  @BeforeEach
  public void before()throws Exception {
    mockVerifiedAuth = new UnauthenticatedManager("username:JugemuJugemu,password:verified");
    mockUnverifiedAuth=new UnauthenticatedManager("username:Pirate,password:booty");
    mockNullCredAuth=new UnauthenticatedManager(null);
    token=null;
    when(mockFireAuth.verifyIdToken(credentials)).thenReturn(token);
  }

  @AfterEach
  public void after(){

  }
  @Test
  public void notNullTest(){   
    assertThat(fireAuthMan).isNotNull();
  }

  @Test
  public void userIsVerifiedTest() throws Exception{
    Assertions.assertThrows(NullPointerException.class,()->{
      fireAuthMan.authenticate(mockVerifiedAuth);});
  }
  
}
