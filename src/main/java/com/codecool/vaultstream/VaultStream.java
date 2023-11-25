package com.codecool.vaultstream;

import com.codecool.vaultstream.logic.IPassphraseValidator;
import com.codecool.vaultstream.ui.MessageToConsole;
import com.codecool.vaultstream.utils.IFileReader;

import java.util.List;

public class VaultStream implements IApp {
    private final String filePath;
    private final IPassphraseValidator validator;
    private final IFileReader fileReader;

    public VaultStream(String filePath, IPassphraseValidator validator, IFileReader fileReader) {
        this.filePath = filePath;
        this.validator = validator;
        this.fileReader = fileReader;
    }

    @Override
    public void run() {
        List<String> passphrases = this.fileReader.readFileLinesInList(filePath);
        int validPassphrasesCount = this.validator.countValidPassphrases(passphrases);
        MessageToConsole.successMessage("Valid passphrase count: " + validPassphrasesCount);
    }
}
