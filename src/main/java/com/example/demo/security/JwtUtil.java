package com.example.demo.security;

import org.springframework;
public class JwtUtil {

    public String generateToken(String email, String role) {
        return email + "-" + role + "-token";
    }
}