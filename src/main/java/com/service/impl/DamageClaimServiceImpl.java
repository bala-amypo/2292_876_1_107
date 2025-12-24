package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.DamageClaimService;
import com.example.demo.util.RuleEngineUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

private final DamageClaimRepository claimRepository;
private final ParcelRepository parcelRepository;
private final ClaimRuleRepository ruleRepository;

// 🔥 ORDER MUST MATCH TEST CONSTRUCTOR
public DamageClaimServiceImpl(
DamageClaimRepository claimRepository,
ParcelRepository parcelRepository,
ClaimRuleRepository ruleRepository) {

this.claimRepository = claimRepository;
this.parcelRepository = parcelRepository;
this.ruleRepository = ruleRepository;
}

@Override
public DamageClaim getClaim(Long claimId) {
return claimRepository.findById(claimId)
.orElseThrow(() ->
new ResourceNotFoundException("claim not found"));
}

@Override
public DamageClaim fileClaim(Long parcelId, DamageClaim claim) {

Parcel parcel = parcelRepository.findById(parcelId)
.orElseThrow(() ->
new ResourceNotFoundException("parcel not found"));

claim.setParcel(parcel);
return claimRepository.save(claim);
}

@Override
public DamageClaim evaluateClaim(Long claimId) {

DamageClaim claim = getClaim(claimId);
List<ClaimRule> rules = ruleRepository.findAll();

double score = RuleEngineUtil.computeScore(
claim.getClaimDescription(),
rules
);

claim.setScore(score);
claim.setAppliedRules(new HashSet<>(rules));
claim.setStatus(score >= 0.5 ? "APPROVED" : "REJECTED");

return claimRepository.save(claim);
}
}