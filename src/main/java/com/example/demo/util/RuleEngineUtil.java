// package com.example.demo.util;

// import com.example.demo.model.ClaimRule;
// import java.util.List;

// public class RuleEngineUtil {

//     // 🔥 EXACT SIGNATURE REQUIRED BY TESTS
//     public static double computeScore(String description, List<ClaimRule> rules) {

//         double score = 0.0;

//         if (rules == null) {
//             return 0.0;
//         }

//         for (ClaimRule rule : rules) {
//             score += rule.getWeight();
//         }

//         return Math.min(score, 1.0);
//     }
// }


package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

    public static double computeScore(String description, List<ClaimRule> rules) {

        if (rules == null || rules.isEmpty()) {
            return 0.0;
        }

        if (description == null || description.trim().isEmpty()) {
            return 0.0;
        }

        double score = 0.0;
        boolean matched = false;

        for (ClaimRule rule : rules) {

            // ❌ Invalid weight → ignore rule
            if (rule.getWeight() < 0) {
                continue;
            }

            String expr = rule.getExpression();

            // ❌ Invalid expression → ignore
            if (expr == null || expr.trim().isEmpty()) {
                continue;
            }

            expr = expr.trim().toUpperCase();

            // ✅ ALWAYS rule
            if ("ALWAYS".equals(expr)) {
                score += rule.getWeight();
                matched = true;
            }

            // ✅ KEYWORD match
            else if (description.toUpperCase().contains(expr)) {
                score += rule.getWeight();
                matched = true;
            }
        }

        // ❌ No match at all
        if (!matched) {
            return 0.0;
        }

        return score;
    }
}
