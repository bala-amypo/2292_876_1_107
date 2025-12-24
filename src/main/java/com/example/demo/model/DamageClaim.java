package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class DamageClaim {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String claimDescription;

@Column
private Double score;   // ONLY ONE score field

private String status;

@ManyToMany
private Set<ClaimRule> appliedRules;

public Long getId() {
return id;
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