package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "claim_rules")
public class ClaimRule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double maxAmount;   
    private double weight;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}