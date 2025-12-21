package com.example.demo.util;

import com.example.demo.model.DamageClaim;
import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    // Static method to evaluate a damage claim against a list of rules
    public static boolean evaluate(DamageClaim claim, List<ClaimRule> rules) {
        if (claim == null || rules == null) {
            return false;
        }

        // Example logic: check if claim amount is within all rules' limits
        for (ClaimRule rule : rules) {
            if (claim.getAmount() > rule.getMaxAmount()) {
                return false; // claim violates a rule
            }
        }
        return true; // all rules passed
    }
}