package com.example.demo.repository;

import com.example.demo.model.Parcel;

import java.util.Optional;

/**
 * IMPORTANT:
 * - This is NOT a JpaRepository
 * - Acts as a common parent required by tests
 */
public interface ParcelRepository {

    boolean existsByTrackingNumber(String trackingNumber);

    Optional<Parcel> findByTrackingNumber(String trackingNumber);
}
