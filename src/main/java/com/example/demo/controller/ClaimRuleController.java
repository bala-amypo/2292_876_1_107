package com.example.demo.controller;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/rules")
@Tag(name = "Claim Rules", description = "Claim rule management endpoints")
public class ClaimRuleController {
    
    private final ClaimRuleService ruleService;
    
    public ClaimRuleController(ClaimRuleService ruleService) {
        this.ruleService = ruleService;
    }
    
    @PostMapping
    @Operation(summary = "Add new claim rule")
    public ResponseEntity<ClaimRule> addRule(@RequestBody ClaimRule rule) {
        ClaimRule savedRule = ruleService.addRule(rule);
        return ResponseEntity.ok(savedRule);
    }
    
    @GetMapping
    @Operation(summary = "Get all claim rules")
    public ResponseEntity<List<ClaimRule>> getAllRules() {
        List<ClaimRule> rules = ruleService.getAllRules();
        return ResponseEntity.ok(rules);
    }
}