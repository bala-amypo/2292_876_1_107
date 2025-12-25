package com.example.demo.repository;

import com.example.demo.model.Parcel;
import java.util.Optional;

public interface ParcelRepository {

    boolean existsByTrackingNumber(String trackingNumber);

    Optional<Parcel> findByTrackingNumber(String trackingNumber);
}
