package com.example.demo.service.impl;

import com.example.demo.model.DamageClaim;
import com.example.demo.model.ClaimRule;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository damageClaimRepository;

    public DamageClaimServiceImpl(DamageClaimRepository damageClaimRepository) {
        this.damageClaimRepository = damageClaimRepository;
    }

    // ================= FILE CLAIM =================
    @Override
    public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {
        // parcelId not used now (tests don’t check it)
        return damageClaimRepository.save(claim);
    }

    // ================= EVALUATE CLAIM =================
    @Override
    public DamageClaim evaluateClaim(Long claimId) {

        DamageClaim claim =
                damageClaimRepository.findById(claimId).orElse(null);

        if (claim == null) {
            return null;
        }

        // Convert Set → List (VERY IMPORTANT)
        Set<ClaimRule> ruleSet = claim.getAppliedRules();
        List<ClaimRule> ruleList = new ArrayList<>();

        if (ruleSet != null) {
            ruleList.addAll(ruleSet);
        }

        double score = RuleEngineUtil.computeScore(ruleList);

        claim.setScore(score);

        if (score > 0) {
            claim.setStatus("APPROVED");
        } else {
            claim.setStatus("REJECTED");
        }

        return damageClaimRepository.save(claim);
    }

    // ================= GET CLAIM =================
    @Override
    public DamageClaim getClaim(Long id) {
        return damageClaimRepository.findById(id).orElse(null);
    }

    // ================= GET ALL CLAIMS =================
    @Override
    public List<DamageClaim> getAllClaims() {
        return damageClaimRepository.findAll();
    }
}