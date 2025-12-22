package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/damage-claims")
public class DamageClaimController {

    private final DamageClaimService damageClaimService;

    public DamageClaimController(DamageClaimService damageClaimService) {
        this.damageClaimService = damageClaimService;
    }

    @PostMapping("/{parcelId}")
    public ResponseEntity<?> fileClaim(
            @PathVariable Long parcelId,
            @RequestBody DamageClaim claim) {

        if (claim.getDescription() == null) {
            return ResponseEntity.badRequest().body("Description required");
        }

        try {
            return ResponseEntity.ok(
                    damageClaimService.fileClaim(parcelId, claim)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<DamageClaim>> getAllClaims() {
        return ResponseEntity.ok(damageClaimService.getAllClaims());
    }
}