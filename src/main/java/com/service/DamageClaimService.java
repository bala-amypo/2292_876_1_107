package com.example.demo.service;

import com.example.demo.model.DamageClaim;

import java.util.List;

public interface DamageClaimService {

    DamageClaim fileClaim(Long parcelId, DamageClaim claim);

    DamageClaim evaluateClaim(Long claimId);

    DamageClaim getClaim(Long id);

    List<DamageClaim> getAllClaims();
}