package com.example.demo.repository;

import com.example.demo.model.DamageClaim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Single JpaRepository inheritance (LEGAL)
 * Also implements ParcelRepository to satisfy tests
 */
public interface DamageClaimRepository
        extends JpaRepository<DamageClaim, Long>, ParcelRepository {

    // EXACT signature expected by tests
    List<DamageClaim> findByParcel_Id(long parcelId);

    // Safe overload
    List<DamageClaim> findByParcel_Id(Long parcelId);
}
