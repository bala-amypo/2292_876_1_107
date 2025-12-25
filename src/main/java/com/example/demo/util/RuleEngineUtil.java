public static double computeScore(String description, List<ClaimRule> rules) {

    if (rules == null || rules.isEmpty()) {
        return 0.0;
    }

    double score = 0.0;
    double totalWeight = 0.0;

    for (ClaimRule rule : rules) {

        // ✅ IGNORE invalid weights
        if (rule.getWeight() == null || rule.getWeight() <= 0) {
            continue;
        }

        totalWeight += rule.getWeight();

        if ("ALWAYS".equalsIgnoreCase(rule.getExpression())) {
            score += rule.getWeight();
        } 
        else if (description != null &&
                 rule.getExpression() != null &&
                 description.toLowerCase().contains(rule.getExpression().toLowerCase())) {
            score += rule.getWeight();
        }
    }

    if (totalWeight == 0) {
        return 0.0;
    }

    return score;
}
