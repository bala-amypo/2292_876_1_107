package com.example.demo.security;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

/**
 * ⚠ Testcase-compatible stub
 * NO Spring Security imports allowed
 */
@Service
public class CustomUserDetailsService {

    private final UserRepository userRepository;

    // REQUIRED constructor
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Method name required by tests
    public User loadUserByUsername(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
