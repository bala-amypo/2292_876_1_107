package com.example.demo.repository;

import com.example.demo.model.DamageClaim;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DamageClaimRepository
        extends JpaRepository<DamageClaim, Long> {

    // ✅ Correct Spring Data nested property method
    List<DamageClaim> findByParcelId(Long parcelId);
}
