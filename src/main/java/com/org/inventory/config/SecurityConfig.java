package com.org.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


/**
 * Security configuration class for the application.
 * 
 * This class configures the security rules for the application, including authentication and authorization of HTTP requests.
 * It uses Spring Security to establish access rules for different routes of the application.
 * 
 * The configuration includes:
 * - OAuth2 authentication to allow login via Google or other OAuth2 providers.
 * - Access restrictions to certain routes requiring authentication.
 * - Disabling CSRF and enabling CORS to allow access from different origins.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {


     /**
     * Configures HTTP security rules for the application.
     * @param http The HttpSecurity object used to customize the security configuration.
     * @return The SecurityFilterChain containing the custom security configuration.
     * @throws Exception If an error occurs during security configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers( "/login", "/", "/swagger-ui/**", "/v3/api-docs/**").permitAll()
                                .requestMatchers("/api/products/**").authenticated()
                                .anyRequest().authenticated()
                )
                .oauth2Login(oauth2Login ->
                oauth2Login
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                )
                .oauth2ResourceServer().jwt()
                .and()
                .and()
                .cors().and().csrf().disable();
        return http.build();
    }
}