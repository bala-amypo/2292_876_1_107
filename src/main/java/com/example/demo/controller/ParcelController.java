package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcels")
@Tag(name = "Parcels", description = "Parcel management endpoints")
public class ParcelController {
    
    private final ParcelService parcelService;
    
    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }
    
    @PostMapping
    @Operation(summary = "Add new parcel")
    public ResponseEntity<Parcel> addParcel(@RequestBody Parcel parcel) {
        Parcel savedParcel = parcelService.addParcel(parcel);
        return ResponseEntity.ok(savedParcel);
    }
    
    @GetMapping("/tracking/{trackingNumber}")
    @Operation(summary = "Get parcel by tracking number")
    public ResponseEntity<Parcel> getByTrackingNumber(@PathVariable String trackingNumber) {
        Parcel parcel = parcelService.getByTrackingNumber(trackingNumber);
        return ResponseEntity.ok(parcel);
    }
}