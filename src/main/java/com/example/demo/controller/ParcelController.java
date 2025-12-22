package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    // CREATE PARCEL
    @PostMapping
    public ResponseEntity<Parcel> createParcel(@RequestBody Parcel parcel) {
        return ResponseEntity.ok(parcelService.createParcel(parcel));
    }

    // GET ALL PARCELS
    @GetMapping
    public ResponseEntity<List<Parcel>> getAllParcels() {
        return ResponseEntity.ok(parcelService.getAllParcels());
    }

    // GET PARCEL BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Parcel> getParcel(@PathVariable Long id) {
        return ResponseEntity.ok(parcelService.getParcel(id));
    }

    // GET PARCEL BY TRACKING NUMBER
    @GetMapping("/tracking/{trackingNumber}")
    public ResponseEntity<Parcel> getByTrackingNumber(
            @PathVariable String trackingNumber) {
        return ResponseEntity.ok(
                parcelService.getByTrackingNumber(trackingNumber)
        );
    }
}