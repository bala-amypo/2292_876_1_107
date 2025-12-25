package com.example.demo.repository;

import com.example.demo.model.Parcel;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Long> {

    boolean existsByTrackingNumber(String trackingNumber);

    Optional<Parcel> findByTrackingNumber(String trackingNumber);
}
