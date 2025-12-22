package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evidence")
public class EvidenceController {

    private final EvidenceService evidenceService;

    public EvidenceController(EvidenceService evidenceService) {
        this.evidenceService = evidenceService;
    }

    @PostMapping("/{claimId}")
    public ResponseEntity<?> addEvidence(
            @PathVariable Long claimId,
            @RequestBody Evidence evidence) {

        if (evidence.getFileUrl() == null) {
            return ResponseEntity.badRequest().body("fileUrl required");
        }

        try {
            return ResponseEntity.ok(
                    evidenceService.addEvidence(claimId, evidence)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{claimId}")
    public ResponseEntity<List<Evidence>> getEvidenceForClaim(
            @PathVariable Long claimId) {

        return ResponseEntity.ok(
                evidenceService.getEvidenceForClaim(claimId)
        );
    }
}