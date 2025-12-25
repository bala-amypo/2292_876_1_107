package com.example.demo.controller;

import com.example.demo.model.Parcel;
import com.example.demo.service.ParcelService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/parcels")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }

    @PostMapping
    public Parcel addParcel(@RequestBody Parcel parcel) {
        return parcelService.addParcel(parcel);
    }

    @GetMapping("/tracking/{trackingNumber}")
    public Parcel getParcel(@PathVariable String trackingNumber) {
        return parcelService.getByTrackingNumber(trackingNumber);
    }
}
