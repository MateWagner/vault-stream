package com.codecool.vaultstream;

import com.codecool.vaultstream.data.ValidationRules;
import com.codecool.vaultstream.logic.IPassphraseValidator;
import com.codecool.vaultstream.logic.PassphraseValidator;
import com.codecool.vaultstream.ui.MessageToConsole;
import com.codecool.vaultstream.utils.FileReader;
import com.codecool.vaultstream.utils.IFileReader;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            argumentValidation(args);
            String filePath = args[0];
            Set<String> validationRegexRules = ValidationRules.getStringRegexRule();
            IFileReader fileReader = new FileReader();
            IPassphraseValidator validator = new PassphraseValidator(validationRegexRules);
            run(filePath, validator, fileReader);
        } catch (Exception e) {
            MessageToConsole.errorMessage(e.getMessage());
        }

    }

    private static void run(String filePath, IPassphraseValidator validator, IFileReader fileReader) {
        List<String> passphrases = fileReader.readFileLinesInList(filePath);
        int validPassphrasesCount = validator.countValidPassphrases(passphrases);
        MessageToConsole.successMessage("Valid passphrase count: " + validPassphrasesCount);
    }

    private static void argumentValidation(String[] args) {
        boolean haveArgument = args.length > 0;
        if (!haveArgument) {
            throw new IllegalArgumentException("You need to provide the relative file path as an argument!");
        }
    }
}
