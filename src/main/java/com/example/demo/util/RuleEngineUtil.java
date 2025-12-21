package com.example.demo.util;

import java.util.List;
import com.example.demo.model.ClaimRule;

public class RuleEngineUtil {

    public static int computeScore(
            String claimType,
            String severity,
            List<ClaimRule> rules) {

        int score = 0;

        if (rules != null) {
            for (ClaimRule rule : rules) {
                score += rule.getWeight();
            }
        }

        return score;
    }
}