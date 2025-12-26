package com.example.demo.security;

import java.util.Base64;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(Long userId, String email, String role) {
        String rawToken = userId + ":" + email + ":" + role;
        return Base64.getEncoder().encodeToString(rawToken.getBytes());
    }

    public String validateToken(String token) {
        return new String(Base64.getDecoder().decode(token));
    }
}

