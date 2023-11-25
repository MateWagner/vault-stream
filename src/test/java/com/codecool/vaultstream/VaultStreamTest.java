package com.codecool.vaultstream;

import com.codecool.vaultstream.logic.IPassphraseValidator;
import com.codecool.vaultstream.utils.IFileReader;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class VaultStreamTest {

    @Test
    void appRun() {
        String filePath = "input.txt";
        IPassphraseValidator validator = Mockito.mock(IPassphraseValidator.class);
        IFileReader fileReader = Mockito.mock(IFileReader.class);

        List<String> passphrases = Arrays.asList("passphrase1", "passphrase2");
        when(fileReader.readFileLinesInList(filePath)).thenReturn(passphrases);
        when(validator.countValidPassphrases(passphrases)).thenReturn(2);

        VaultStream vaultStream = new VaultStream(filePath, validator, fileReader);

        vaultStream.run();

        verify(fileReader, times(1)).readFileLinesInList(filePath);
        verify(validator, times(1)).countValidPassphrases(passphrases);
    }

}
