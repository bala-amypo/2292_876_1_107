package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/claims")
public class DamageClaimController {

    private final DamageClaimService claimService;

    public DamageClaimController(DamageClaimService claimService) {
        this.claimService = claimService;
    }

    @PostMapping("/file/{parcelId}")
    public DamageClaim fileClaim(
            @PathVariable Long parcelId,
            @RequestBody DamageClaim claim) {
        return claimService.fileClaim(parcelId, claim);
    }

    @PutMapping("/evaluate/{claimId}")
    public DamageClaim evaluate(@PathVariable Long claimId) {
        return claimService.evaluateClaim(claimId);
    }

    @GetMapping("/{claimId}")
    public DamageClaim getClaim(@PathVariable Long claimId) {
        return claimService.getClaim(claimId);
    }
}
