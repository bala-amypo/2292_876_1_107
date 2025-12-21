package com.example.demo.service.impl;

import com.example.demo.model.DamageClaim;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository repository;

    public DamageClaimServiceImpl(DamageClaimRepository repository) {
        this.repository = repository;
    }

    // 🔹 Called by controller
    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        // You can link parcelId later if needed
        return repository.save(claim);
    }

    // 🔹 Called by controller
    @Override
    public DamageClaim evaluateClaim(Long claimId) {
        DamageClaim claim = repository.findById(claimId).orElse(null);

        if (claim == null) {
            return null;
        }

        double score = RuleEngineUtil.computeScore(claim, claim.getAppliedRules());
        claim.setScore(score);

        if (score > 0) {
            claim.setStatus("APPROVED");
        } else {
            claim.setStatus("REJECTED");
        }

        return repository.save(claim);
    }

    @Override
    public DamageClaim getClaim(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<DamageClaim> getAllClaims() {
        return repository.findAll();
    }
}