// package com.example.demo.security;

// import java.util.Base64;
// import org.springframework.stereotype.Component;

// @Component
// public class JwtUtil {

//     public String generateToken(Long userId, String email, String role) {
//         String rawToken = userId + ":" + email + ":" + role;
//         return Base64.getEncoder().encodeToString(rawToken.getBytes());
//     }

//     public String validateToken(String token) {
//         return new String(Base64.getDecoder().decode(token));
//     }
// }


package com.example.demo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private static final String SECRET = "secretkey123";

    public String generateToken(String email, String role) {

        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(System.currentTimeMillis() + 86400000)
                )
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }
}
