package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PhysicalDataTest {

    private PhysicalData physicalData;

    @BeforeEach
    public void setUp() throws BuildException {
        this.physicalData = PhysicalData.getInstance(10.0, 5.0, 15.0, 20.0, false);
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
            physicalData = physicalData.getInstance(10.0, 5.0, 15.0, 20.0, false);
            assertNotNull(physicalData);
        } catch (BuildException e) {
            fail("Error en el GetInstance de PhysicalData: " + e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithInvalidHigh() {
        try {
            physicalData.getInstance(-10.0, 5.0, 15.0, 20.0, false);
            fail("Expected BuildException due to invalid high");
        } catch (BuildException e) {
            assertEquals("Failed to create PhysicalData: Bad high; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithInvalidWidth() {
        try {
            physicalData.getInstance(10.0, -5.0, 15.0, 20.0, false);
            fail("Expected BuildException due to invalid width");
        } catch (BuildException e) {
            assertEquals("Failed to create PhysicalData: Bad width; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithInvalidLength() {
        try {
            physicalData.getInstance(10.0, 5.0, -15.0, 20.0, false);
            fail("Expected BuildException due to invalid length");
        } catch (BuildException e) {
            assertEquals("Failed to create PhysicalData: Bad length; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithInvalidWeight() {
        try {
            physicalData.getInstance(10.0, 5.0, 15.0, -20.0, false);
            fail("Expected BuildException due to invalid weight");
        } catch (BuildException e) {
            assertEquals("Failed to create PhysicalData: Bad weight; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithInvalidValues() {
        try {
            physicalData.getInstance(-10.0, -5.0, -15.0, -20.0, false);
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
    void testSetHighValid() {
        assertEquals(0, physicalData.setHigh(10.0));
        assertEquals(10.0, physicalData.getHigh());
    }

    @Test
    void testSetHighInvalid() {
        physicalData.setHigh(-10);
        assertEquals(-1, physicalData.setHigh(-10.0));
    }

    @Test
    void testSetHighZero() {
        assertEquals(-1, physicalData.setHigh(0));
    }

    @Test
    void testSetHighExceedsLimitsMinim() {
        assertEquals(-1, physicalData.setHigh(-100.0)); 
        assertEquals(10.0, physicalData.getHigh()); 
    }

    @Test
    void testSetLengthValid() {
        assertEquals(0, physicalData.setLength(10.0));
        assertEquals(10.0, physicalData.getLength());
    }

    @Test
    void testSetLengthInvalid() {
        assertEquals(-1, physicalData.setLength(-1.0));
    }

    @Test
    void testSetLengthExceedsLimitsMinim() {
        assertEquals(-1, physicalData.setLength(-100.0)); 
        assertEquals(15.0, physicalData.getLength()); 
    }

    @Test
    void testSetWeightValid() {
        assertEquals(0, physicalData.setWeight(10.0));
        assertEquals(10.0, physicalData.getWeight());
    }

    @Test
    void testSetWeightInvalid() {
        assertEquals(-1, physicalData.setWeight(-5.0));
    }

    @Test
    void testSetWeightExceedsLimitsMinim() {
        assertEquals(-1, physicalData.setWeight(-100.0)); 
        assertEquals(20.0, physicalData.getWeight()); 
    }

    @Test
    void testSetWidthValid() {
        assertEquals(0, physicalData.setWidth(10.0));
        assertEquals(10.0, physicalData.getWidth());
    }

    @Test
    void testSetWidthInvalid() {
        assertEquals(-1, physicalData.setWidth(-5.0));
    }

    @Test
    void testSetWeidthExceedsLimitsMinim() {
        assertEquals(-1, physicalData.setWidth(-100.0)); 
        assertEquals(5.0, physicalData.getWidth());
    }

    @Test
    void testGetInstanceWithZeroValues() {
        assertThrows(BuildException.class, () -> {
            PhysicalData.getInstance(0.0, 0.0, 0.0, 0.0, false);
        });
    }

    @Test
    void testToString() {
        physicalData.setHigh(10.0);
        physicalData.setWidth(5.0);
        physicalData.setLength(15.0);
        physicalData.setWeight(20.0);
        physicalData.setFragile(false);
        assertEquals("PhysicalData[high=10.0, width=5.0, length=15.0, weight=20.0, fragile=false]",
                physicalData.toString());
    }
}