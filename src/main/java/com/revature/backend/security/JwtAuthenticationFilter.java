package com.revature.backend.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.backend.config.FirebaseConfig;
import com.revature.backend.model.Manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * The JwtAuthenticationFilter is used in tandem with Firebase to intercept
 * incoming requests
 * and authorize them
 * @author Jay Monari
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final Logger logger = LoggerFactory.getLogger(getClass());
  private final AuthenticationManager authenticationManager;

  public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
    this.authenticationManager = authenticationManager;
  }
  public JwtAuthenticationFilter(){
    FirebaseConfig temp=new FirebaseConfig();
    this.authenticationManager=temp.firebaseAuthenticationManager();
  }

  /**
   * Checks if the incoming request contains actuator and if it does
   * passes it on to the next filter. If the incoming request does have a JWT
   * it will extract the JWT and add the appropriate authentication to the
   * request.
   * @param request
   * @param response
   * @param filterChain
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request,
        HttpServletResponse response, FilterChain filterChain) throws
        ServletException, IOException {
    // First we check if we need to intercept the request
    final String requestUri = request.getRequestURI();
    if (requestUri.contains("actuator")) {
      filterChain.doFilter(request, response);
      return;
    }
    // Then we extract the JWT if there is one
    final String header = request.getHeader("Authorization");
    String token = null;
    Authentication authentication = null;
    if (header != null && header.startsWith("Bearer ")) {
      token = header.replace("Bearer ", "");
      // authentication =
      //     authenticationManager.authenticate(new UnauthenticatedManager(token));
    } else {
      logger.info("No JWT Token present, ignoring Header");
    }

    // and finally set the appropriate authorities to the request
    if (authentication instanceof Manager) { //TODO make sure this works
      UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
          authentication.getName(), "", AuthorityUtils.createAuthorityList("ROLE_USER"));
      authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
      SecurityContextHolder.getContext().setAuthentication(authToken);
    }

    filterChain.doFilter(request, response);
  }
}
