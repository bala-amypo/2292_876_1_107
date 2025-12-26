// package com.example.demo.security;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
// import org.springframework.web.filter.OncePerRequestFilter;
// import org.springframework.stereotype.Component;
// import java.io.IOException;
// import java.util.Collections;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;

// @Component // ✅ THIS IS THE FIX
// public class JwtAuthenticationFilter extends OncePerRequestFilter {

//     private final JwtUtil jwtUtil;

//     public JwtAuthenticationFilter(JwtUtil jwtUtil) {
//         this.jwtUtil = jwtUtil;
//     }

//     @Override
//     protected void doFilterInternal(
//             HttpServletRequest request,
//             HttpServletResponse response,
//             FilterChain filterChain)
//             throws ServletException, IOException {

//         String header = request.getHeader("Authorization");

//         if (header != null && header.startsWith("Bearer ")) {

//             String token = header.substring(7);
//             String decoded = jwtUtil.validateToken(token);

//             String[] parts = decoded.split(":");
//             String email = parts[1];
//             String role = parts[2];

//             UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                     email,
//                     null,
//                     Collections.singletonList(
//                             new SimpleGrantedAuthority("ROLE_" + role)));

//             authentication.setDetails(
//                     new WebAuthenticationDetailsSource()
//                             .buildDetails(request));

//             SecurityContextHolder.getContext()
//                     .setAuthentication(authentication);
//         }

//         filterChain.doFilter(request, response);
//     }
// }


package com.example.demo.security;

import com.example.demo.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            if (jwtUtil.isTokenValid(token)) {
                String email = jwtUtil.extractEmail(token);
                String role = jwtUtil.extractRole(token);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                email,
                                null,
                                Collections.singleton(
                                        new SimpleGrantedAuthority("ROLE_" + role)
                                )
                        );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}
