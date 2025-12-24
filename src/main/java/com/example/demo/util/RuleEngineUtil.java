package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String description, List<ClaimRule> rules) {

        if (description == null || description.isBlank() || rules == null) {
            return 0.0;
        }

        double score = 0.0;

        for (ClaimRule rule : rules) {
            score += rule.getWeight();
        }

        return Math.min(score, 1.0);
    }
}
