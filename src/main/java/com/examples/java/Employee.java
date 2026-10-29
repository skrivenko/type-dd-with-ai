package com.examples.java;

public class Employee {
    public RawRequest createRequest(Visitor visitor) {
        return new RawRequest(visitor, null, null);
    }

    public RawRequest addPassportData(RawRequest request, PassportData passportData) {
        return new RawRequest(request.visitor(), request.revisionReason(), passportData);
    }

    public SubmittedRequest submit(RawRequest request) {
        return new SubmittedRequest(request.visitor(), request.passportData());
    }
}
