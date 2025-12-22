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

    @PostMapping
    public ResponseEntity<Parcel> createParcel(@RequestBody Parcel parcel) {
        return ResponseEntity.ok(parcelService.createParcel(parcel));
    }

    @GetMapping
    public ResponseEntity<List<Parcel>> getAllParcels() {
        return ResponseEntity.ok(parcelService.getAllParcels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parcel> getParcel(@PathVariable Long id) {
        return ResponseEntity.ok(parcelService.getParcel(id));
    }

    @GetMapping("/tracking/{trackingNumber}")
    public ResponseEntity<Parcel> getByTrackingNumber(
            @PathVariable String trackingNumber) {
        return ResponseEntity.ok(
                parcelService.getByTrackingNumber(trackingNumber));
    }
}