package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String description, List<ClaimRule> rules) {

        if (rules == null || rules.isEmpty()) {
            return 0.0;
        }

        double score = 0.0;
        double totalWeight = 0.0;

        for (ClaimRule rule : rules) {

            // ✅ weight must be > 0
            if (rule.getWeight() <= 0) {
                continue;
            }

            totalWeight += rule.getWeight();

            // ✅ ALWAYS rule
            if ("ALWAYS".equalsIgnoreCase(rule.getRuleName())) {
                score += rule.getWeight();
            }
            // ✅ Keyword match
            else if (description != null &&
                     rule.getRuleName() != null &&
                     description.toLowerCase().contains(rule.getRuleName().toLowerCase())) {
                score += rule.getWeight();
            }
        }

        // ✅ total zero weight handled
        if (totalWeight == 0) {
            return 0.0;
        }

        return score;
    }
}
