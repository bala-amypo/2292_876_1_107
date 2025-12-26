package com.example.demo.util;

import com.example.demo.model.DamageClaim;
import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {
    
    public static double evaluateRules(DamageClaim claim, List<ClaimRule> rules) {
        return computeScore(claim.getClaimDescription(), rules);
    }
    
    public static double computeScore(String description, List<ClaimRule> rules) {
        if (rules.isEmpty()) {
            return 0.0;
        }
        
        double totalScore = 0.0;
        
        for (ClaimRule rule : rules) {
            if (evaluateRule(description, rule)) {
                totalScore += rule.getWeight();
            }
        }
        
        return Math.min(totalScore, 1.0);
    }
    
    private static boolean evaluateRule(String description, ClaimRule rule) {
        String condition = rule.getConditionExpression();
        
        if ("always".equals(condition)) {
            return true;
        }
        
        if (condition.startsWith("description_contains:")) {
            String keyword = condition.substring("description_contains:".length());
            return description != null && 
                   description.toLowerCase().contains(keyword.toLowerCase());
        }
        
        return false;
    }
}