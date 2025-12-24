package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import com.example.demo.repository.ClaimRuleRepository;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.service.DamageClaimService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

private final DamageClaimRepository claimRepository;
private final ClaimRuleRepository ruleRepository;

public DamageClaimServiceImpl(
DamageClaimRepository claimRepository,
ClaimRuleRepository ruleRepository) {
this.claimRepository = claimRepository;
this.ruleRepository = ruleRepository;
}

@Override
public DamageClaim evaluateClaim(Long claimId) {

DamageClaim claim = claimRepository.findById(claimId)
.orElseThrow(() -> new ResourceNotFoundException("claim not found"));

List<ClaimRule> rules = ruleRepository.findAll();

double score = 0.0;
Set<ClaimRule> matchedRules = new HashSet<>();

String description =
claim.getClaimDescription() == null
? ""
: claim.getClaimDescription().toLowerCase();

for (ClaimRule rule : rules) {
if (description.contains(rule.getKeyword().toLowerCase())) {
score += rule.getWeight();
matchedRules.add(rule);
}
}

claim.setScore(score);
claim.setAppliedRules(matchedRules);

if (score >= 0.5) {
claim.setStatus("APPROVED");
} else {
claim.setStatus("REJECTED");
}

return claimRepository.save(claim);
}
}