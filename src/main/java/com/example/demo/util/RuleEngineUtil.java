package com.example.demo.util;

import java.util.List;
import com.example.demo.model.ClaimRule;
import com.example.demo.model.DamageClaim;

public class RuleEngineUtil {

    public static double computeScore(
            DamageClaim claim,
            List<ClaimRule> rules) {

        double score = 0.0;

        if (rules != null) {
            for (ClaimRule rule : rules) {
                if (claim.getAmount() <= rule.getMaxAmount()) {
                    score += rule.getWeight();
                }
            }
        }

        return score;
    }
}