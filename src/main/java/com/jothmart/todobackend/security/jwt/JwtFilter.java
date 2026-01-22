package com.jothmart.todobackend.security.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.jothmart.todobackend.service.JWTService; 
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext applicationContext;

    @Override 
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            // Extract username from token
            username = jwtService.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // Here you can set the authentication in the security context if needed
                    // For example, you can load user details and create an Authentication object
                    UserDetails userDetails = applicationContext.getBean(UserDetailsService.class).loadUserByUsername(username);
                    if(jwtService.validateToken(token, userDetails)) { // Validate the token and see if the username exists in the database
                        // Set authentication in context
                        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            userDetails, null, userDetails.getAuthorities());
                            //authToken does not know about Object request so I have to set it
                            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request)); 
                            SecurityContextHolder.getContext().setAuthentication(authToken);
                    }
        }
        filterChain.doFilter(request, response);

             //   throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
            }

}
