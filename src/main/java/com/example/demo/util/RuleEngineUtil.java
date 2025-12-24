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
try {
if (rule == null) {
continue;
}

String keyword = rule.getKeyword();
Double weight = rule.getWeight();

if (keyword == null || weight == null) {
continue;
}

if (description.contains(keyword)) {
score += weight;
}

} catch (Exception e) {
// invalid rule must be ignored
}
}

return score;
}
}