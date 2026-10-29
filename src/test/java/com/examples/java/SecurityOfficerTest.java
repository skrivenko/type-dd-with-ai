package com.examples.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecurityOfficerTest {

    @Test
    void shouldReturnRequestForRevision() {
        Employee employee = new Employee();
        Visitor visitor = new Visitor("Анна");
        SubmittedRequest submitted = employee.submit(employee.createRequest(visitor));

        RawRequest returned = new SecurityOfficer().returnForRevision(submitted, "Нужны паспортные данные");

        assertEquals(visitor, returned.visitor());
        assertEquals("Нужны паспортные данные", returned.revisionReason());
    }

    @Test
    void shouldApproveSubmittedRequest() {
        Employee employee = new Employee();
        Visitor visitor = new Visitor("Ольга");
        PassportData passportData = new PassportData("9876 543210");
        SubmittedRequest submitted = employee.submit(employee.createRequest(visitor));
        RawRequest returned = new SecurityOfficer().returnForRevision(submitted, "Нужны паспортные данные");
        SubmittedRequest resubmitted = employee.submit(employee.addPassportData(returned, passportData));

        ApprovedRequest approved = new SecurityOfficer().approve(resubmitted);

        assertEquals(visitor, approved.visitor());
        assertEquals(passportData, approved.passportData());
    }
}
