package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Parcel parcel;

    private String claimDescription;
    private double score;
    private String status = "PENDING";

    @ManyToMany
    private Set<ClaimRule> appliedRules = new HashSet<>();

    public DamageClaim() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Parcel getParcel() { return parcel; }
    public void setParcel(Parcel parcel) { this.parcel = parcel; }

    public String getClaimDescription() { return claimDescription; }
    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Set<ClaimRule> getAppliedRules() { return appliedRules; }
    public void setAppliedRules(Set<ClaimRule> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
