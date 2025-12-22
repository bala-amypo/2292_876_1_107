package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/damage-claims")
public class DamageClaimController {

    private final DamageClaimService damageClaimService;

    public DamageClaimController(DamageClaimService damageClaimService) {
        this.damageClaimService = damageClaimService;
    }

    @PostMapping("/{parcelId}")
    public ResponseEntity<DamageClaim> fileClaim(
            @PathVariable Long parcelId,
            @RequestBody DamageClaim claim) {

        return ResponseEntity.ok(
                damageClaimService.fileClaim(parcelId, claim)
        );
    }
}