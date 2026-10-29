package com.examples.java;

public class Example {

    public String getGreeting() {
        return "Hello, World!";
    }

    public Boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }

    public Boolean isBlankString(String value) {
        return value.isBlank();
    }

    public int getStringLengthWithTrim(String value) {
        return value.trim().length();
    }
}
