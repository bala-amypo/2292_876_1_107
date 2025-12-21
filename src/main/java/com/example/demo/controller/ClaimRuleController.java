package com.example.demo.controller;

import com.example.demo.model.ClaimRule;
import com.example.demo.service.ClaimRuleService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rules")
public class ClaimRuleController {

    private final ClaimRuleService ruleService;

    public ClaimRuleController(ClaimRuleService ruleService) {
        this.ruleService = ruleService;
    }

   
    @GetMapping
    public ResponseEntity<List<ClaimRule>> getAllRules() {
        return ResponseEntity.ok(ruleService.getAllRules());
    }

    
    @PostMapping
    public ResponseEntity<ClaimRule> createRule(@RequestBody ClaimRule rule) {
        ClaimRule savedRule = ruleService.createRule(rule);
        return ResponseEntity.ok(savedRule);
    }
}