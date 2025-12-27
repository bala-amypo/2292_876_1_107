// package com.example.demo.security;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import javax.crypto.SecretKey;
// import java.nio.charset.StandardCharsets;
// import java.util.Date;

// @Component
// public class JwtUtil {

//     private final long expirationMillis;
//     private final SecretKey key;

//     public JwtUtil(
//             @Value("${jwt.secret}") String secretKey,
//             @Value("${jwt.expiration}") long expirationMillis) {

//         if (secretKey.length() < 32) {
//             throw new IllegalStateException(
//                 "JWT secret must be at least 32 characters long"
//             );
//         }

//         this.expirationMillis = expirationMillis;
//         this.key = Keys.hmacShaKeyFor(
//                 secretKey.getBytes(StandardCharsets.UTF_8)
//         );
//     }

//     public String generateToken(Long userId, String email, String role) {
//         return Jwts.builder()
//                 .claim("userId", userId)
//                 .claim("email", email)
//                 .claim("role", role)
//                 .setIssuedAt(new Date())
//                 .setExpiration(
//                         new Date(System.currentTimeMillis() + expirationMillis)
//                 )
//                 .signWith(key)
//                 .compact();
//     }

//     public Claims validateToken(String token) {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }



package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // ✅ HARD-CODED SECRET (NO PLACEHOLDER → NO RUNTIME ERROR)
    private static final String SECRET_KEY = "exam_secret_key_123";

    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 10;

    public String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + EXPIRATION_TIME)
                )
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    public boolean isTokenValid(String token) {
        return !getClaims(token).getExpiration().before(new Date());
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}