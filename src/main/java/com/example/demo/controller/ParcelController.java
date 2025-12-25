package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @PostMapping
    public ResponseEntity<Parcel> addParcel(@RequestBody Parcel parcel) {
        return new ResponseEntity<>(parcelService.addParcel(parcel), HttpStatus.CREATED);
    }

    @GetMapping("/{trackingNumber}")
    public ResponseEntity<Parcel> getByTrackingNumber(@PathVariable String trackingNumber) {
        return ResponseEntity.ok(parcelService.getByTrackingNumber(trackingNumber));
    }
}
