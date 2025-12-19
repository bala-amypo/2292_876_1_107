package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.ExpiredJwtException;

import java.util.Date;

public class JwtUtil {

    private final String secretKey;
    private final long expirationMillis;

    // ✅ REQUIRED constructor (TEST EXPECTS THIS)
    public JwtUtil(String secretKey, long expirationMillis) {
        this.secretKey = secretKey;
        this.expirationMillis = expirationMillis;
    }

    // ✅ REQUIRED signature
    public String generateToken(Long userId, String email, String role) {
        return Jwts.builder()
                .claim("userId", userId)
                .claim("email", email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMillis))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // ✅ REQUIRED by JwtAuthenticationFilter
    public Claims validateToken(String token)
            throws JwtException, ExpiredJwtException {

        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }
}
