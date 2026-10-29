package com.examples.java;

public class SecurityOfficer {
    public RawRequest returnForRevision(SubmittedRequest request, String reason) {
        return new RawRequest(request.visitor(), reason, request.passportData());
    }

    public ApprovedRequest approve(SubmittedRequest request) {
        return new ApprovedRequest(request.visitor(), request.passportData());
    }
}
