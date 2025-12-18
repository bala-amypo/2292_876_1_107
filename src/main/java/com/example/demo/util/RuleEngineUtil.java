package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;
import java.util.List;

public class RuleEngineUtil {

    private RuleEngineUtil() {
    }

    public static double evaluate(DamageClaim claim, List<ClaimRule> rules) {
        double score = 0.0;

        for (ClaimRule rule : rules) {
            score += rule.getWeight();
        }

        return Math.min(score, 1.0);
    }
}