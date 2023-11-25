package com.codecool.vaultstream.data;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum ValidationRules {
    PATTERN_VALIDATION("^([a-z]+ )+([a-z]+)[!.?]{1}$"),
    FILTER_REPEATED_WORDS("^(?:(?!\\b(\\w+)\\b.*\\b\\1\\b).)*$");

    private final String regex_rule;

    ValidationRules(String regex_rule) {
        this.regex_rule = regex_rule;
    }

    public static Set<String> getStringRegexRule() {
        return Arrays.stream(values())
                .map(validationRules -> validationRules.regex_rule)
                .collect(Collectors.toSet());
    }
}
