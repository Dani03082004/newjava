package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

// Preguntar al Jose Meseguer porque sucede este error --> No funciona PhysicalData.getInstance(10.0, 5.0, 15.0, 20.0, false);
// SI funciona como esta puesto

public class PhysicalDataTest {

    private PhysicalData physicalData;

    @BeforeEach
    public void setUp() throws BuildException {
        physicalData = new PhysicalData();
        physicalData = PhysicalData.getInstance(10.0, 5.0, 15.0, 20.0, false);
    }
    
    
    @Test
    void testGetFragile() {
        assertFalse(physicalData.getFragile());
    }

    @Test
    void testGetHigh() {
        assertEquals(10.0, physicalData.getHigh());
    }

    @Test
    void testGetInstanceValid() {
        try {
            PhysicalData physicalData = new PhysicalData();
            physicalData = physicalData.getInstance(10.0, 5.0, 15.0, 20.0, false);
            assertNotNull(physicalData);
        } catch (BuildException e) {
            fail("Error en el GetInstance de PhysicalData: " + e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithInvalidHigh() {
        try {
            PhysicalData physicalData = new PhysicalData();
            physicalData = physicalData.getInstance(-10.0, 5.0, 15.0, 20.0, false);
            fail("Expected BuildException due to invalid high");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad high"));
        }
    }

    @Test
    void testGetInstanceWithInvalidWidth() {
        try {
            PhysicalData physicalData = new PhysicalData();
            physicalData = physicalData.getInstance(10.0, -5.0, 15.0, 20.0, false);
            fail("Expected BuildException due to invalid width");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad width"));
        }
    }

    @Test
    void testGetInstanceWithInvalidLength() {
        try {
            PhysicalData physicalData = new PhysicalData();
            physicalData = physicalData.getInstance(10.0, 5.0, -15.0, 20.0, false);
            fail("Expected BuildException due to invalid length");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad length"));
        }
    }

    @Test
    void testGetInstanceWithInvalidWeight() {
        try {
            PhysicalData physicalData = new PhysicalData();
            physicalData = physicalData.getInstance(10.0, 5.0, 15.0, -20.0, false);
            fail("Expected BuildException due to invalid weight");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad weight"));
        }
    }

    @Test
    void testGetInstanceWithInvalidValues() {
        try {
            PhysicalData physicalData = new PhysicalData();
            physicalData = physicalData.getInstance(-10.0, -5.0, -15.0, -20.0, false);
            fail("Expected BuildException due to invalid values");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad high"));
            assertTrue(e.getMessage().contains("Bad width"));
            assertTrue(e.getMessage().contains("Bad length"));
            assertTrue(e.getMessage().contains("Bad weight"));
        }
    }

    @Test
    void testGetLength() {
        assertEquals(15.0, physicalData.getLength());
    }

    @Test
    void testGetSize() {
        physicalData.setHigh(10.0);
        physicalData.setWidth(5.0);
        physicalData.setLength(15.0);
        assertEquals("high: 10.0; width: 5.0; length: 15.0", physicalData.getSize());
    }

    @Test
    void testGetVolume() {
        physicalData.setHigh(10.0);
        physicalData.setWidth(5.0);
        physicalData.setLength(15.0);
        assertEquals(750.0, physicalData.getVolume());
    }

    @Test
    void testGetWeight() {
        assertEquals(20.0, physicalData.getWeight());
    }

    @Test
    void testGetWidth() {
        assertEquals(5.0, physicalData.getWidth());
    }

    @Test
    void testSetFragile() {
        physicalData.setFragile(true);
        assertTrue(physicalData.getFragile());
    }

    @Test
    void testSetHighInvalid() {
        physicalData.setHigh(-10);
        assertEquals(-1, physicalData.setHigh(-10.0));
    }

    @Test
    void testSetHighValid() {
        assertEquals(0, physicalData.setHigh(10.0));
        assertEquals(10.0, physicalData.getHigh());
    }

    @Test
    void testSetLengthInvalid() {
        assertEquals(-1, physicalData.setLength(-1.0));
    }

    @Test
    void testSetLengthValid() {
        assertEquals(0, physicalData.setLength(10.0));
        assertEquals(10.0, physicalData.getLength());
    }

    @Test
    void testSetWeightInvalid() {
        assertEquals(-1, physicalData.setWeight(-5.0));
    }

    @Test
    void testSetWeightValid() {
        assertEquals(0, physicalData.setWeight(10.0));
        assertEquals(10.0, physicalData.getWeight());
    }

    @Test
    void testSetWidthInvalid() {
        assertEquals(-1, physicalData.setWidth(-5.0));
    }

    @Test
    void testSetWidthValid() {
        assertEquals(0, physicalData.setWidth(10.0));
        assertEquals(10.0, physicalData.getWidth());
    }

    @Test
    void testToString() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setHigh(10.0);
        physicalData.setWidth(5.0);
        physicalData.setLength(15.0);
        physicalData.setWeight(20.0);
        physicalData.setFragile(false);
        assertEquals("PhysicalData[high=10.0, width=5.0, length=15.0, weight=20.0, fragile=false]",
                physicalData.toString());
    }
}