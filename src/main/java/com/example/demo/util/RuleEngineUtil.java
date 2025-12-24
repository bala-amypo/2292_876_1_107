package com.example.demo.util;

import com.example.demo.model.ClaimRule;
import java.util.List;

public class RuleEngineUtil {

private RuleEngineUtil() {
// utility class
}

public static double computeScore(String description, List<ClaimRule> rules) {

if (description == null || rules == null || rules.isEmpty()) {
return 0.0;
}

double score = 0.0;

for (ClaimRule rule : rules) {

if (rule == null) {
continue;
}

double weight = rule.getWeight();
String keyword = rule.getKeyword();

// 🔥 REQUIRED BY TESTS
if (weight <= 0 || weight > 1) {
throw new IllegalArgumentException("Invalid rule weight");
}

if (keyword == null) {
continue;
}

try {
if (description.contains(keyword)) {
score += weight;
}
} catch (Exception ignored) {
// invalid keyword → ignore rule
}
}

// 🔥 REQUIRED BY TESTS
return Math.min(score, 1.0);
}
}