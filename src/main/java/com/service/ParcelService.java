package com.example.demo.service;

import com.example.demo.model.Parcel;

import java.util.List;

public interface ParcelService {

    Parcel createParcel(Parcel parcel);

    List<Parcel> getAllParcels();

    Parcel getParcel(Long id);

    Parcel getByTrackingNumber(String trackingNumber);
}