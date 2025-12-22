package com.example.demo.controller;

import com.example.demo.model.Evidence;
import com.example.demo.service.EvidenceService;
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
    public Evidence addEvidence(
            @PathVariable Long claimId,
            @RequestBody Evidence evidence) {

        return evidenceService.addEvidence(claimId, evidence);
    }

    @GetMapping("/{claimId}")
    public List<Evidence> getEvidence(
            @PathVariable Long claimId) {

        return evidenceService.getEvidenceForClaim(claimId);
    }
}