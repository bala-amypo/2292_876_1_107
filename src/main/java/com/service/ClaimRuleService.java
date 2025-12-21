package com.example.demo.service;

import com.example.demo.model.ClaimRule;
import java.util.List;

public interface ClaimRuleService {
    List<ClaimRule> getAllRules();
    ClaimRule createRule(ClaimRule rule);
}