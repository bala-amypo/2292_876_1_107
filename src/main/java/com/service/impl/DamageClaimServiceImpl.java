package com.example.demo.service.impl;

import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import org.springframework.stereotype.Service;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository damageClaimRepository;
    private final ParcelRepository parcelRepository;

    public DamageClaimServiceImpl(
            DamageClaimRepository damageClaimRepository,
            ParcelRepository parcelRepository) {

        this.damageClaimRepository = damageClaimRepository;
        this.parcelRepository = parcelRepository;
    }

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {

        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));

        claim.setParcel(parcel);
        claim.setStatus("FILED");

        return damageClaimRepository.save(claim);
    }
}