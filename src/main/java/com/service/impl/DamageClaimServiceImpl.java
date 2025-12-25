package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import org.springframework.stereotype.Service;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository claimRepository;
    private final ParcelRepository parcelRepository;

    public DamageClaimServiceImpl(DamageClaimRepository claimRepository,
                                  ParcelRepository parcelRepository) {
        this.claimRepository = claimRepository;
        this.parcelRepository = parcelRepository;
    }

    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        Parcel parcel = parcelRepository.findById(parcelId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Parcel not found"));

        claim.setParcel(parcel);
        return claimRepository.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long claimId) {
        return claimRepository.findById(claimId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Claim not found"));
    }

    // ✅ REQUIRED BY INTERFACE (FIXES ERROR)
    @Override
    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim claim = getClaim(claimId);
        claim.setStatus("EVALUATED");
        return claimRepository.save(claim);
    }
}
