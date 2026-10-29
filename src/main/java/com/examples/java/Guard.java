package com.examples.java;

public class Guard {
    public IssuedPass issuePass(ApprovedRequest request) {
        return new IssuedPass(request.visitor());
    }
}
