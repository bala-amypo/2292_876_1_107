package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {

    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @PostMapping("/{claimId}")
    public ResponseEntity<Evidence> upload(
            @PathVariable Long claimId,
            @RequestBody Evidence evidence) {

        return ResponseEntity.ok(
                evidenceService.uploadEvidence(claimId, evidence)
        );
    }

    @GetMapping("/{claimId}")
    public ResponseEntity<List<Evidence>> getByClaim(@PathVariable Long claimId) {
        return ResponseEntity.ok(
                evidenceService.getEvidenceForClaim(claimId)
        );
    }
}