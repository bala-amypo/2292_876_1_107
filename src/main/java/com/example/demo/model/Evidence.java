package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
@Table(name = "evidence")
public class Evidence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private DamageClaim claim;

    private String evidenceType;
    private String fileUrl;
    private LocalDateTime uploadedAt;

    public Evidence() {
    }

    @PrePersist
    public void onUpload() {
        this.uploadedAt = LocalDateTime.now();
    }

    public void setClaim(DamageClaim claim) {
        this.claim = claim;
    }
}
