package com.examples.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeTest {

    @Test
    void shouldCreateRequestForVisitor() {
        Visitor visitor = new Visitor("Иван");

        RawRequest raw = new Employee().createRequest(visitor);

        assertEquals(visitor, raw.visitor());
    }

    @Test
    void shouldSubmitRawRequest() {
        RawRequest raw = new Employee().createRequest(new Visitor("Мария"));

        SubmittedRequest submitted = new Employee().submit(raw);

        assertEquals(raw.visitor(), submitted.visitor());
    }

    @Test
    void shouldResubmitRequestWithPassportData() {
        Employee employee = new Employee();
        Visitor visitor = new Visitor("Пётр");
        SubmittedRequest submitted = employee.submit(employee.createRequest(visitor));
        RawRequest returned = new SecurityOfficer().returnForRevision(submitted, "Нужны паспортные данные");
        PassportData passportData = new PassportData("1234 567890");

        RawRequest completed = employee.addPassportData(returned, passportData);
        SubmittedRequest resubmitted = employee.submit(completed);

        assertEquals(visitor, resubmitted.visitor());
        assertEquals(passportData, resubmitted.passportData());
    }
}
