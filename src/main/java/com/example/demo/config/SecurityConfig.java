package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // Disable CSRF for REST APIs & Swagger
            .csrf(csrf -> csrf.disable())

            // Authorize requests
            .authorizeHttpRequests(auth -> auth

                // ✅ Allow Swagger URLs
                .requestMatchers(
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**"
                ).permitAll()

                // ✅ Allow authentication endpoints if any
                .requestMatchers("/auth/**").permitAll()

                // ❌ Secure everything else
                .anyRequest().authenticated()
            );

        return http.build();
    }
}