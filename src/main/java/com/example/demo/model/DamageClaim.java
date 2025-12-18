package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "damage_claims")
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parcel_id", nullable = false)
    private Parcel parcel;

    private String claimDescription;
    private LocalDateTime filedAt;
    private String status; // PENDING / APPROVED / REJECTED
    private Double score;

    @ManyToMany
    @JoinTable(
        name = "claim_applied_rules",
        joinColumns = @JoinColumn(name = "claim_id"),
        inverseJoinColumns = @JoinColumn(name = "rule_id")
    )
    private List<ClaimRule> appliedRules;

    @PrePersist
    public void prePersist() {
        this.filedAt = LocalDateTime.now();
        this.status = "PENDING";
    }

    // Default Constructor
    public DamageClaim() {}

    // Parameterized Constructor
    public DamageClaim(Long id, Parcel parcel, String claimDescription,
                       LocalDateTime filedAt, String status, Double score) {
        this.id = id;
        this.parcel = parcel;
        this.claimDescription = claimDescription;
        this.filedAt = filedAt;
        this.status = status;
        this.score = score;
    }

    // Getters and Setters
    public Long getId() { 
    return id;
     }
    public void setId(Long id) { 
    this.id = id; 
    }

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

    public LocalDateTime getFiledAt() {
     return filedAt;
      }
    public void setFiledAt(LocalDateTime filedAt) {
     this.filedAt = filedAt;
      }

    public String getStatus() {
     return status; 
     }
    public void setStatus(String status) { 
    this.status = status;
     }

    public Double getScore() {
     return score;
      }
    public void setScore(Double score) { 
    this.score = score; 
    }

    public List<ClaimRule> getAppliedRules() { return appliedRules; }
    public void setAppliedRules(List<ClaimRule> appliedRules) {
        this.appliedRules = appliedRules;
    }
}
