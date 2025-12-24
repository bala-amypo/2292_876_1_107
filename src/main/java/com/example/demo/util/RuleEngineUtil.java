package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String claimDescription,
                                      List<ClaimRule> rules) {

        if (claimDescription == null || rules == null || rules.isEmpty()) {
            return 0.0;
        }

        double score = 0.0;

        for (ClaimRule rule : rules) {
            if (rule.getDescription() != null &&
                claimDescription.toLowerCase()
                    .contains(rule.getDescription().toLowerCase())) {

                score += rule.getWeight();
            }
        }

        // ✅ Tests expect score capped at 1.0
        return Math.min(score, 1.0);
    }
}
