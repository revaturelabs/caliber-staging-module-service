package com.revature.backend.config;

import com.revature.backend.security.JwtAuthenticationFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Jay Monari
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final JwtAuthenticationFilter jwtAuthenticationFilter;

  public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
    this.jwtAuthenticationFilter = jwtAuthenticationFilter;
  }

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
