package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.time.LocalDateTime;

@Entity
@Table(name = "parcels")
public class Parcel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String trackingNumber;

    private String senderName;
    private String receiverName;
    private Double weightKg;
    private LocalDateTime deliveredAt;

    public Parcel() {
    }

    public Parcel(String trackingNumber, String senderName, String receiverName, Double weightKg) {
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.weightKg = weightKg;
    }

    public Long getId() {
        return id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public Double getWeightKg() {
        return weightKg;
    }
}
