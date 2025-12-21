package com.example.demo.service.impl;

import com.example.demo.model.DamageClaim;
import com.example.demo.repository.DamageClaimRepository;
import com.example.demo.service.DamageClaimService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DamageClaimServiceImpl implements DamageClaimService {

    private final DamageClaimRepository repository;

    public DamageClaimServiceImpl(DamageClaimRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DamageClaim> getAllClaims() {
        return repository.findAll();
    }

    @Override
    public DamageClaim createClaim(DamageClaim claim) {
        return repository.save(claim);
    }
}