package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ClaimRule {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String ruleName;
private String description;
private double weight;

// JPA constructor
public ClaimRule() {
}

// REQUIRED BY TEST CASES
public ClaimRule(String ruleName, String description, double weight) {
this.ruleName = ruleName;
this.description = description;
this.weight = weight;
}

// getters & setters
public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public String getRuleName() {
return ruleName;
}

public void setRuleName(String ruleName) {
this.ruleName = ruleName;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

// 🔥 REQUIRED BY RuleEngineUtil & Service layer
public String getKeyword() {
return description;
}

public double getWeight() {
return weight;
}

public void setWeight(double weight) {
this.weight = weight;
}
}