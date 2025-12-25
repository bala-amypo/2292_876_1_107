package com.example.demo.service;

import com.example.demo.model.DamageClaim;

public interface DamageClaimService {

    DamageClaim fileClaim(Long parcelId, DamageClaim claim);

    DamageClaim getClaim(Long claimId);

    DamageClaim evaluateClaim(Long claimId);
}
