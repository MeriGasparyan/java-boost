package com.merigasparyan.jmp.Task3;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class EmployeeTest {
    @Test
    void testCreateCommissionedEmployee() {
        Employee emp = EmployeeFactory.createCommissioned("Alice", 0.1, 10000, 0.05);

        assertNotNull(emp);
        assertEquals("Alice", emp.getName());

        assertEquals(new Money(1000), emp.calculatePay());
        assertEquals(new Money(500), emp.calculateBonus());
    }

    @Test
    void testCreateHourlyEmployee_NoOvertime() {
        Employee emp = EmployeeFactory.createHourly("Bob", 20, 35, 40, 10);

        assertNotNull(emp);
        assertEquals("Bob", emp.getName());
        assertEquals(new Money(700), emp.calculatePay());
        assertEquals(new Money(0), emp.calculateBonus());
    }

    @Test
    void testCreateHourlyEmployee_WithOvertime() {
        Employee emp = EmployeeFactory.createHourly("Carol", 20, 45, 40, 15);

        assertNotNull(emp);
        assertEquals("Carol", emp.getName());
        assertEquals(new Money(900), emp.calculatePay());
        assertEquals(new Money(75), emp.calculateBonus());
    }

    @Test
    void testCreateSalariedEmployee() {
        Employee emp = EmployeeFactory.createSalaried("Dave", 4000, 0.1);

        assertNotNull(emp);
        assertEquals("Dave", emp.getName());
        assertEquals(new Money(4000), emp.calculatePay());
        assertEquals(new Money(400), emp.calculateBonus());
    }
}
