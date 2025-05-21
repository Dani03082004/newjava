package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.operations;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;

public class OperationOBJTest {

    private OperationOBJ operationOBJ;

    @BeforeEach
    public void setUp() throws BuildException, DateException {
        operationOBJ = new OperationOBJ();
        operationOBJ.CheckOperData(1, "Test Description", "01/01/2023 10:00:00");
    }

    @Test
    void testGetInstanceValid() {
        assertDoesNotThrow(() -> {
            operationOBJ.CheckOperData(1, "Test Description", "01/01/2023 10:00:00");
        });
    }

    @Test
    void testGetInstanceWithInvalidRef() throws BuildException, DateException {
        try {
            operationOBJ.CheckOperData(0, "Test Description", "01-01-2023 10:00:00");
            fail("Expected BuildException due to invalid reference");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Reference; "));
        }
    }

    @Test
    void testGetInstanceWithInvalidDescription() throws BuildException, DateException {
        try {
            operationOBJ.CheckOperData(1, "", "01-01-2023 10:00:00");
            fail("Expected BuildException due to invalid description");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Description; "));
        }
    }

    @Test
    void testGetInstanceWithInvalidInitDate() throws BuildException, DateException {
        try {
            operationOBJ.CheckOperData(1, "Test Description", "011-01-2023 10:00:00");
            fail("Expected BuildException due to invalid Init Date");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Init Date; "));
        }
    }

    @Test
    void testGetReference() {
        assertEquals(1, operationOBJ.getReference());
    }

    @Test
    void testSetReference() {
        assertTrue(operationOBJ.setReference(2));
    }

    @Test
    void testSetReferenceInvalid() {
        assertFalse(operationOBJ.setReference(-1));
        assertFalse(operationOBJ.setReference(0));
    }

    @Test
    void testGetDescription() {
        assertEquals("Test Description", operationOBJ.getDescription());
    }

    @Test
    void testSetDescription() {
        assertTrue(operationOBJ.setDescription("New Description"));
    }

    @Test
    void testSetDescriptionInvalid() {
        assertFalse(operationOBJ.setDescription(""));
        assertFalse(operationOBJ.setDescription("1234"));
        assertFalse(operationOBJ.setDescription(null));
    }

    @Test
    void testGetInitdate() {
        assertEquals("01/01/2023 10:00:00", operationOBJ.getInitdate());
    }

    @Test
    void testSetInitDate() throws DateException {
        assertTrue(operationOBJ.setInitDate("02/01/2023 10:00:00"));
    }

    @Test
    void testSetInitDateInvalidNull() throws DateException {
        assertFalse(operationOBJ.setInitDate(null));
        assertFalse(operationOBJ.setInitDate(""));

    }

    @Test
    void testSetInitDateInvalidSeconds() {
        assertThrows(DateException.class, () -> {
            assertFalse(operationOBJ.setInitDate("02/01/2023 10:00:111"));
        });
    }

    @Test
    void testSetInitDateInvalidMinutes() {
        assertThrows(DateException.class, () -> {
            assertFalse(operationOBJ.setInitDate("02/01/2023 10:111:00"));
        });
    }

    @Test
    void testSetInitDateInvalidHour() {
        assertThrows(DateException.class, () -> {
            assertFalse(operationOBJ.setInitDate("02/01/2023 101:11:00"));
        });
    }

    @Test
    void testSetInitDateInvalidDate() {
        assertThrows(DateException.class, () -> {
            assertFalse(operationOBJ.setInitDate("0222/01/2023 10:00:00"));
        });
    }

    @Test
    void testSetInitDateInvalidMonth() {
        assertThrows(DateException.class, () -> {
            assertFalse(operationOBJ.setInitDate("02/011/2023 10:00:00"));
        });
    }

    @Test
    void testSetInitDateInvalidYear() {
        assertThrows(DateException.class, () -> {
            assertFalse(operationOBJ.setInitDate("02/01/202322 10:00:00"));
        });
    }

    @Test
    void testSetInitDateInvalidFebruary() {
        assertThrows(DateException.class, () -> {
            assertFalse(operationOBJ.setInitDate("31/02/2024 10:00:00"));
        });
    }


    @Test
    void testGetContactData() throws DateException {
        operationOBJ.setReference(1);
        operationOBJ.setDescription("Test Description");
        operationOBJ.setInitDate("01/01/2023 10:00:00");
        assertEquals("OperationOBJ [reference=1, description=Test Description, initdate=01/01/2023 10:00:00]", operationOBJ.getContactData());
    }

    @Test
    void testGetDetails() throws DateException {
        operationOBJ.setReference(1);
        operationOBJ.setDescription("Test Description");
        operationOBJ.setInitDate("01/01/2023 10:00:00");
        assertEquals("OperationOBJ [reference=1, description=Test Description, initdate=01/01/2023 10:00:00]", operationOBJ.getDetails());
    }

}
