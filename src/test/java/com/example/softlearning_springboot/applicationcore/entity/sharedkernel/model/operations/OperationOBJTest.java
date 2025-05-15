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
        operationOBJ.CheckOperData(1, "Test Description", "2023-01-01");
    }

    @Test
    void testGetInstanceValid() {
        assertDoesNotThrow(() -> {
            operationOBJ.CheckOperData(1, "Test Description", "2023-01-01");
        });
    }

    @Test
    void testGetInstanceWithInvalidRef() throws BuildException, DateException {
        try {
            operationOBJ.CheckOperData(0, "Test Description", "2023-01-01");
            fail("Expected BuildException due to invalid reference");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Reference; "));
        }
    }

    @Test
    void testGetInstanceWithInvalidDescription() throws BuildException, DateException {
        try {
            operationOBJ.CheckOperData(1, "", "2023-01-01");
            fail("Expected BuildException due to invalid description");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad description; "));
        }
    }

    @Test
    void testGetInstanceWithInvalidInitDate() throws BuildException, DateException {
        try {
            operationOBJ.CheckOperData(1, "Test Description", "202-013-01");
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
    void testGetDescription() {
        assertEquals("Test Description", operationOBJ.getDescription());
    }

    // TODO: Comprobar el método getStatus y SetStatus

    @Test
    void testGetInitdate() {
        assertEquals("2023-01-01", operationOBJ.getInitdate());
    }

    @Test
    void testGetDetails() {

    }

    //TODO: hacer el finish date, añadirlo en la clase operation

    @Test
    void testGetStatus() {

    }

    @Test
    void testSetDescription() {

    }

    @Test
    void testSetFinishDate() {

    }

    @Test
    void testSetInitDate() {

    }

    @Test
    void testSetReference() {

    }

}
