package com.example.demo.service;

import com.example.demo.model.DamageClaim;
import java.util.List;

public interface DamageClaimService {

    DamageClaim createClaim(DamageClaim claim);

    DamageClaim getClaim(Long id);   // 🔥 REQUIRED

    List<DamageClaim> getAllClaims();
}