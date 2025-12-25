package com.example.demo.repository;

import com.example.demo.model.DamageClaim;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface DamageClaimRepository extends JpaRepository<DamageClaim, Long> {
    Optional<DamageClaim> findById(Long claimId);

    List<DamageClaim> findByParcel_Id(Long parcelId);
}
