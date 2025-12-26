// package com.example.demo.service;

// import com.example.demo.model.DamageClaim;

// public interface DamageClaimService {

//     DamageClaim fileClaim(Long parcelId, DamageClaim claim);

//     DamageClaim evaluateClaim(Long claimId);

//     DamageClaim getClaim(Long claimId);
// }


package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DamageClaim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    // ✅ MUST be null initially
    private Double score = null;

    private String status = "PENDING";

    @ManyToOne
    private Parcel parcel;

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
}
