package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;

    public User() {
    }

    // ===== REQUIRED BY TESTS & SECURITY =====

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // 🔥 MISSING → CAUSED 4 ERRORS
    public String getPassword() {
        return password;
    }

    // 🔥 REQUIRED BY AuthController
    public void setPassword(String password) {
        this.password = password;
    }

    // 🔥 REQUIRED BY UserServiceImpl
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
