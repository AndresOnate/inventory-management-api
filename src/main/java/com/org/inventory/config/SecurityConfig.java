package com.org.inventory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers( "/login", "/", "**.js", "**.css").permitAll()
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