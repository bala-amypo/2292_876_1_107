package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {
public static double computeScore(String description, List<ClaimRule> rules) {}
if (description == null || rules == null || rules.isEmpty()) {
return 0.0;
}

double score = 0.0;

for (ClaimRule rule : rules) {
try {
if (description.contains(rule.getKeyword())) {
score += rule.getWeight();
}
} catch (Exception e) {
    
}
}

return score;
}


