package com.examples.java;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {

    @Test
    public void shouldReturnWellKnownPhrase() {
        var subject = new Example();

        var actual = subject.getGreeting();

        assertEquals("Hello, World!", actual);
    }

    @ParameterizedTest
    @ValueSource(ints = { 2, 4, 18, 346 })
    void shouldDefineNumberIsEven(int number) {
        var subject = new Example();

        var actual = subject.isEvenNumber(number);

        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(strings = { "1", " 3 ", "  3 " })
    void shouldDefineStringIsNotBlank(String value) {
        var subject = new Example();

        var actual = subject.isBlankString(value);

        assertFalse(actual);
    }

    @ParameterizedTest
    @CsvSource({
            "hello world, 11",
            " hello,       5",
            "hello    ,    5"
    })
    void shouldDefinePhraseLengthWithoutLeadingAndTrailingSpaces(String phrase, int expectedLength) {
        var subject = new Example();

        var actual = subject.getStringLengthWithTrim(phrase);

        assertThat(actual).isEqualTo(expectedLength);
    }
}
