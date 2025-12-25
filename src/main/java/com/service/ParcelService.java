package com.example.demo.service;

import com.example.demo.model.Parcel;

public interface ParcelService {

    Parcel createParcel(Parcel parcel);

    Parcel getParcelByTrackingNumber(String trackingNumber);
}
