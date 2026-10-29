package com.examples.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PassTest {
    @Test
    void happyPass() {
        Employee employee = new Employee();
        RawRequest raw = employee.createRequest(new Visitor("Посетитель"));
        SubmittedRequest submitted = employee.submit(raw);

        SecurityOfficer securityOfficer = new SecurityOfficer();
        RawRequest returned = securityOfficer.returnForRevision(submitted, "Нужны паспортные данные");
        RawRequest completed = employee.addPassportData(returned, new PassportData("1234 567890"));
        SubmittedRequest resubmitted = employee.submit(completed);
        ApprovedRequest approved = securityOfficer.approve(resubmitted);
        IssuedPass pass = new Guard().issuePass(approved);

        assertNotNull(pass);
    }
}
