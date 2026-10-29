package com.examples.java;

public record RawRequest(Visitor visitor, String revisionReason, PassportData passportData) {
}
