package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email) {
        return email + "-token";
    }

    public String extractUsername(String token) {
        return token.split("-")[0];
    }
}