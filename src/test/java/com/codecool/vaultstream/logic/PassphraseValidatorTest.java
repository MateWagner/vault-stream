package com.codecool.vaultstream.logic;

import com.codecool.vaultstream.data.ValidationRules;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PassphraseValidatorTest {

    PassphraseValidator validator;

    @BeforeEach
    void setUp() {
        this.validator = new PassphraseValidator(ValidationRules.getStringRegexRule());
    }

    @ParameterizedTest
    @ValueSource(
            strings = {
                    "a b!",
                    "a b c.",
                    "a b ca.",
                    "a ab ca.",
                    "aa ab ca.",
                    "alma madar!",
                    "alma madar.",
                    "alma madar?",
                    "alma madar madarak?",
                    "alma madar madarak maradek?",
                    "alma madar kocsi hajo koplejk aksdnwhqwoiwqwdf?",
            }
    )
    void shouldValidate(String passphrase) {
        List<String> pancreases = List.of(passphrase);
        int expected = 1;
        int result = validator.countValidPassphrases(pancreases);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(
            strings = {
                    "a!",
                    "a.",
                    "a?",
                    "aa.",
                    "alma!",
                    "madar.",
                    "alma?",
                    "madarak?",
                    "maradek?",
                    "aksdnwhqwoiwqwdf?",
            }
    )
    void shouldFail_OneWord(String passphrase) {
        List<String> pancreases = List.of(passphrase);
        int expected = 0;
        int result = validator.countValidPassphrases(pancreases);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(
            strings = {
                    "a b",
                    "a b c",
                    "a b ca",
                    "a ab ca",
                    "aa ab ca",
                    "alma madar",
                    "alma madar",
                    "alma madar",
                    "alma madar madarak",
                    "alma madar madarak maradek",
                    "alma madar kocsi hajo koplejk aksdnwhqwoiwqwdf",
            }
    )
    void shouldFail_NoPunctuationMark(String passphrase) {
        List<String> pancreases = List.of(passphrase);
        int expected = 0;
        int result = validator.countValidPassphrases(pancreases);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(
            strings = {
                    "a a!",
                    "a a b c.",
                    "a b ca b.",
                    "ca a ab ca.",
                    "aa ab ca aa.",
                    "alma madar alma!",
                    "alma madar madar.",
                    "madar alma madar?",
                    "alma madar madarak madarak?",
                    "alma madar madarak maradek alma?",
                    "aksdnwhqwoiwqwdf alma madar kocsi hajo koplejk aksdnwhqwoiwqwdf?",
            }
    )
    void shouldFail_SameWordMultipleTime(String passphrase) {
        List<String> pancreases = List.of(passphrase);
        int expected = 0;
        int result = validator.countValidPassphrases(pancreases);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(
            strings = {
                    "aá b!",
                    "a, b c.",
                    "a &b ca.",
                    "a a%b ca.",
                    "aa ab! ca.",
                    "aa ab1 ca.",
                    "alma madar.!",
                    "alm+a madar.",
                    "alma  madar?",
                    " alma madar madarak?",
                    "alma ma\\dar madarak maradek?",
                    "alma madar kocsi hajo koplejk aksdnwhqwoiwqwdf? ",
            }
    )
    void shouldFail_IncorrectCharacters(String passphrase) {
        List<String> pancreases = List.of(passphrase);
        int expected = 0;
        int result = validator.countValidPassphrases(pancreases);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @ValueSource(
            strings = {
                    "A b!",
                    "a B c.",
                    "a b cA.",
                    "a aB ca.",
                    "aA ab ca.",
                    "alma maDar!",
                    "alma madarR.",
                    "alMa madar?",
                    "alma madar mMdarak?",
                    "alma madar madarak MARADEK?",
                    "alma madar kocsi hajo koplejk HJSFJJIWDSDH aksdnwhqwoiwqwdf?",
            }
    )
    void shouldFail_OnlyLowerCase(String passphrase) {
        List<String> pancreases = List.of(passphrase);
        int expected = 0;
        int result = validator.countValidPassphrases(pancreases);
        assertEquals(expected, result);
    }

    @Test
    void shouldGet_ElevenValidFromMixedList() {
        List<String> pancreases = List.of(
                "a b!",
                "a b c.",
                "a b ca.",
                "A b!",
                "a B c.",
                "alma madar madarak maradek?",
                "a b cA.",
                "a aB ca.",
                "alma madar.",
                "aA ab ca.",
                "alma madar?",
                "alma maDar!",
                "alma madar madarak?",
                "alma madarR.",
                "alma madar!",
                "a ab ca.",
                "alMa madar?",
                "alma madar mMdarak?",
                "alma madar kocsi hajo koplejk aksdnwhqwoiwqwdf?",
                "aa ab ca.",
                "alma madar madarak MARADEK?",
                "alma madar kocsi hajo koplejk HJSFJJIWDSDH aksdnwhqwoiwqwdf?"
        );
        int expected = 11;
        int result = validator.countValidPassphrases(pancreases);
        assertEquals(expected, result);
    }
}
