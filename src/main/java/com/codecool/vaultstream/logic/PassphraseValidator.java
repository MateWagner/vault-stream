package com.codecool.vaultstream.logic;

import com.codecool.vaultstream.ui.MessageToConsole;

import java.util.List;
import java.util.Set;

public class PassphraseValidator implements IPassphraseValidator {
    private final Set<String> regexRules;

    public PassphraseValidator(Set<String> regexRules) {
        this.regexRules = regexRules;
    }

    @Override
    public int countValidPassphrases(List<String> passphrases) {
        if (passphrases.isEmpty()) {
            MessageToConsole.errorMessage("Empty File!");
        }
        return passphrases.stream()
                .mapToInt(passphrase -> isPassphraseValid(passphrase) ? 1 : 0)
                .sum();
    }


    private boolean isPassphraseValid(String passphrase) {
        return regexRules.stream()
                .allMatch(passphrase::matches);
    }
}
