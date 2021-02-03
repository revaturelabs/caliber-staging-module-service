package com.revature.backend.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Jay Monari
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .antMatchers("/h2-console/**")
        .permitAll();

    httpSecurity.csrf().disable();
    httpSecurity.headers().frameOptions().disable();
  }
}
