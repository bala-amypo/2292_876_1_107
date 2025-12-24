package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DamageClaim {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

// 🔥 REQUIRED BY SERVICE LAYER
@ManyToOne
private Parcel parcel;

private String claimDescription;

private Double score; // must be nullable initially

private String status = "PENDING";

@ManyToMany
private Set<ClaimRule> appliedRules = new HashSet<>();

public DamageClaim() {
}

public Long getId() {
return id;
}

// 🔥 REQUIRED METHODS
public Parcel getParcel() {
return parcel;
}

public void setParcel(Parcel parcel) {
this.parcel = parcel;
}

public String getClaimDescription() {
return claimDescription;
}

public void setClaimDescription(String claimDescription) {
this.claimDescription = claimDescription;
}

public Double getScore() {
return score;
}

public void setScore(Double score) {
this.score = score;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Set<ClaimRule> getAppliedRules() {
return appliedRules;
}

public void setAppliedRules(Set<ClaimRule> appliedRules) {
this.appliedRules = appliedRules;
}
}