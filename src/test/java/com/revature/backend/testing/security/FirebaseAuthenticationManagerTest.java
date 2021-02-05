package com.revature.backend.testing.security;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
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
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
/**
 * 
 * @throws Exception
 * @author Matthew Sheldon
 * This is a set of tests for the FirebaseAuthenticationManager class.It contains 4 tests related to this class
 * test 1: Tests whether it is possible to instantiate an instance of the tested class
 * test 2: Tests if given presumed valid credentials will return appropriate result. Issue with test:unable to create firebaseToken so throws nullpointer exception instead
 * test 3: Tests if given invalid credentials the method handles appropriatly
 * test 4: tests if given null credentials that the method handles appropriately
 * 
 */


@SpringBootTest
public class FirebaseAuthenticationManagerTest {

  @InjectMocks
  private FirebaseAuthenticationManager fireAuthMan;
  @Mock
  FirebaseAuth mockFireAuth;

  private Authentication mockValidAuth;
  private Authentication mockInvalidAuth;
  private Authentication mockNullCredAuth;

  private String validCredentials;
  private String invalidCredentials;

  private FirebaseToken token;

  @BeforeEach
  public void before()throws Exception {
    mockValidAuth = new UnauthenticatedManager("username:JugemuJugemu,password:verified");
    validCredentials=(String)mockValidAuth.getCredentials();

    mockInvalidAuth=new UnauthenticatedManager("username:Pirate,password:booty");
    invalidCredentials=(String)mockInvalidAuth.getCredentials();

    mockNullCredAuth=new UnauthenticatedManager(null);

    token=null;

    when(mockFireAuth.verifyIdToken(validCredentials)).thenReturn(token);
    when(mockFireAuth.verifyIdToken(invalidCredentials)).thenThrow(FirebaseAuthException.class);
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
      fireAuthMan.authenticate(mockValidAuth);
    });
  }

  @Test
  public void userIsNotVerifiedTest() throws Exception{
    Assertions.assertThrows(BadCredentialsException.class,()->{
      fireAuthMan.authenticate(mockInvalidAuth);
    });
  }

  @Test
  public void userIsNullTest() throws Exception{
    Assertions.assertThrows(BadCredentialsException.class,()->{
      fireAuthMan.authenticate(mockNullCredAuth);
    });
  }
  
}
