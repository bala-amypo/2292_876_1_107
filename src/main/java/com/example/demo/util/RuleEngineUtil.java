package com.example.demo.util;

import com.example.demo.model.ClaimRule;

import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(List<ClaimRule> rules) {

        double score = 0.0;

        if (rules != null) {
            for (ClaimRule rule : rules) {
                score += rule.getWeight();
            }
        }

        return score;
    }
}