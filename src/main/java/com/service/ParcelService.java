package com.example.demo.service;

import com.example.demo.model.Parcel;

public interface ParcelService {

    // Existing methods
    Parcel createParcel(Parcel parcel);

    Parcel getParcelByTrackingNumber(String trackingNumber);

    // 🔥 Methods REQUIRED by controller & tests
    Parcel addParcel(Parcel parcel);

    Parcel getByTrackingNumber(String trackingNumber);
}
