package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(List<ClaimRule> rules) {

        double score = 0.0;

        for (ClaimRule rule : rules) {
            if (rule.getWeight() != null) {
                score += rule.getWeight();
            }
        }

        // score must be between 0.0 and 1.0
        return Math.min(score, 1.0);
    }
}
