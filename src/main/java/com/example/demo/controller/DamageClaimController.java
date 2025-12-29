package com.example.demo.controller;

import com.example.demo.model.DamageClaim;
import com.example.demo.service.DamageClaimService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/claims")
@Tag(name = "Damage Claims", description = "Damage claim management endpoints")
public class DamageClaimController {
    
    private final DamageClaimService claimService;
    
    public DamageClaimController(DamageClaimService claimService) {
        this.claimService = claimService;
    }
    
    @PostMapping("/file/{parcelId}")
    @Operation(summary = "File new damage claim")
    public ResponseEntity<DamageClaim> fileClaim(@PathVariable Long parcelId, @RequestBody DamageClaim claim) {
        DamageClaim savedClaim = claimService.fileClaim(parcelId, claim);
        return ResponseEntity.ok(savedClaim);
    }
    
    @PutMapping("/evaluate/{claimId}")
    @Operation(summary = "Evaluate damage claim")
    public ResponseEntity<DamageClaim> evaluateClaim(@PathVariable Long claimId) {
        DamageClaim evaluatedClaim = claimService.evaluateClaim(claimId);
        return ResponseEntity.ok(evaluatedClaim);
    }
    
    @GetMapping("/{claimId}")
    @Operation(summary = "Get damage claim by ID")
    public ResponseEntity<DamageClaim> getClaim(@PathVariable Long claimId) {
        DamageClaim claim = claimService.getClaim(claimId);
        return ResponseEntity.ok(claim);
    }
}
