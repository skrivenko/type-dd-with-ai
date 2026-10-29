package com.examples.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuardTest {

    @Test
    void shouldIssuePassForVisitor() {
        Visitor visitor = new Visitor("Сергей");
        ApprovedRequest approved = new ApprovedRequest(visitor, new PassportData("1111 222233"));

        IssuedPass pass = new Guard().issuePass(approved);

        assertEquals(visitor, pass.visitor());
    }
}
