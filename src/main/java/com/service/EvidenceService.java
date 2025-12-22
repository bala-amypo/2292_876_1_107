package com.example.demo.service;

import com.example.demo.model.Evidence;


public interface EvidenceService {

    Evidence addEvidence(Long claimId, Evidence evidence);

}