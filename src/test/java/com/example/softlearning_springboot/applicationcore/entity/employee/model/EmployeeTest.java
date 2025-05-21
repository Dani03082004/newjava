package com.example.softlearning_springboot.applicationcore.entity.employee.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;

public class EmployeeTest {

    private Employee employee;

    @BeforeEach
    public void setUp() throws BuildException, DateException {
        employee = Employee.getInstance(1, "Manolo", "Calle Falsa", "García", 123456789,
        11111, "manolo@example.com", "01-01-1990",
        1200, "Técnico", "usuario123", "contraSegura123", "31-12-2025");
    }

    @Test
    void testGetInstanceSuccess() throws DateException, BuildException {
        try{
            Employee.getInstance(1, "Manolo", "Calle Falsa", "García", 123456789,
            11111, "manolo@example.com", "01-01-1990",
            1200, "Técnico", "usuario123", "contraSegura123", "31-12-2025");
            assertNotNull(employee);
        } catch (BuildException e) {
            fail("Error en el GetInstance de Employee: " + e.getMessage());
        }
    }

    @Test
    void testGetInstanceFailsWithBadData() {
        Exception ex = assertThrows(BuildException.class, () -> {
            Employee.getInstance(1, "Pepe", "Calle", "Sánchez", 111111111, 12345, "correo@mal", "01-01-1990",
                    -10, "rol", "u", "123", "31-12-2025");
        });
        assertTrue(ex.getMessage().contains("Failed to create Employee"));
    }

    @Test
    void testGetSalary() {
        assertEquals(1200, employee.getSalary());
    }

    @Test
    void testSetSalaryValid() {
        assertTrue(employee.setSalary(1000));
    }

    @Test
    void testSetSalaryInvalid() {
        assertFalse(employee.setSalary(-50));
        assertFalse(employee.setSalary(0));
    }

    @Test
    void testGetRole() {
        assertEquals("Técnico", employee.getRole());
    }

    @Test
    void testSetRoleValid() {
        assertTrue(employee.setRole("Manager"));
    }

    @Test
    void testSetRoleInvalid() {
        assertFalse(employee.setRole("abc"));
        assertFalse(employee.setRole(""));
        assertFalse(employee.setRole(null));
    }

    @Test
    void testGetUser() {
        assertEquals("usuario123", employee.getUser());
    }

    @Test
    void testSetUserValid() {
        assertTrue(employee.setUser("usuarioValido"));
    }

    @Test
    void testSetUserInvalid() {
        assertFalse(employee.setUser(""));
        assertFalse(employee.setUser("abc"));
        assertFalse(employee.setUser(null));
    }

    @Test
    void testGetPassword() {
        assertEquals("contraSegura123", employee.getPassword());
    }

    @Test
    void testSetPasswordValid() {
        assertTrue(employee.setPassword("Segura123"));
    }

    @Test
    void testSetPasswordInvalid() {
        assertFalse(employee.setPassword("abc"));
        assertFalse(employee.setPassword(""));
        assertFalse(employee.setPassword(null));
    }

    @Test
    void testSetDaysValid() throws DateException {
        assertTrue(employee.setDays("01-01-2030"));
    }

    @Test
    void testSetDaysInvalid() {
        assertDoesNotThrow(() -> assertFalse(employee.setDays("2020/12/12")));
    }

    @Test
    void testGetDays() throws DateException {
        assertEquals("31-12-2025", employee.getDays().format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    @Test
    void testGetDaysRemaining() throws DateException {
        employee.setDays(LocalDate.now().plusDays(10).format(java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        int remaining = employee.getDaysRemaining();
        assertTrue(remaining >= 9 && remaining <= 10); 
    }
}
