package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    // 🔥 EXACT SIGNATURE REQUIRED BY TESTS
    public static double computeScore(String description, List<ClaimRule> rules) {

        double score = 0.0;

        if (rules == null) {
            return 0.0;
        }

        for (ClaimRule rule : rules) {
            if (rule.getWeight() >= 0) {
                score += rule.getWeight();
            }
        }

        return Math.min(score, 1.0);
    }
}
