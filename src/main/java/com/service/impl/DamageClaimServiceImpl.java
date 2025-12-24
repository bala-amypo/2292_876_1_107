package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository claimRepository;
    private final ClaimRuleRepository ruleRepository;

    public DamageClaimServiceImpl(DamageClaimRepository claimRepository,
                                  ClaimRuleRepository ruleRepository) {
        this.claimRepository = claimRepository;
        this.ruleRepository = ruleRepository;
    }

    // ✅ REQUIRED BY INTERFACE
    @Override
    public DamageClaim getClaim(Long id) {
        return claimRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("claim not found"));
    }

    // ✅ CLAIM EVALUATION (TEST-ALIGNED)
    @Override
    public DamageClaim evaluateClaim(Long claimId) {

        DamageClaim claim = claimRepository.findById(claimId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("claim not found"));

        List<ClaimRule> rules = ruleRepository.findAll();

        double score = RuleEngineUtil.computeScore(
                claim.getClaimDescription(),
                rules
        );

        claim.setScore(score);
        claim.setAppliedRules(new HashSet<>(rules));

        if (score >= 0.5) {
            claim.setStatus("APPROVED");
        } else {
            claim.setStatus("REJECTED");
        }

        return claimRepository.save(claim);
    }
}
