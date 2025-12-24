package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "damage_claims")
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Parcel parcel;

    private String claimDescription;
    private LocalDateTime filedAt;
    private String status;
    private Double score;

    @ManyToMany
    private Set<ClaimRule> appliedRules = new HashSet<>();

    public DamageClaim() {
        this.status = "PENDING";
    }

    @PrePersist
    public void onCreate() {
        this.filedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAppliedRules(Set<ClaimRule> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
