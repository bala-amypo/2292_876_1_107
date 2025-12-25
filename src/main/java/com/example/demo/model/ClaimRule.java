// package com.example.demo.model;

// import jakarta.persistence.*;

// @Entity
// public class ClaimRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     private String expression;   // ✅ REQUIRED BY RULE ENGINE

//     private double weight;

//     // ===== Getters & Setters =====

//     public Long getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getExpression() {
//         return expression;
//     }

//     public double getWeight() {
//         return weight;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public void setExpression(String expression) {
//         this.expression = expression;
//     }

//     public void setWeight(double weight) {
//         this.weight = weight;
//     }
// }


package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ClaimRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String expression;

    private double weight;

    // ===== REQUIRED GETTERS =====

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // ✅ REQUIRED BY RuleEngineUtil
    public String getRuleName() {
        return name;
    }

    public String getExpression() {
        return expression;
    }

    public double getWeight() {
        return weight;
    }

    // ===== SETTERS =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

