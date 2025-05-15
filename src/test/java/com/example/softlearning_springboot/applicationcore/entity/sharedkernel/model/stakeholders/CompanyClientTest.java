package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CompanyClientTest {

    private CompanyClient companyClient;

    @BeforeEach
    public void setUp() throws BuildException {
        this.companyClient = CompanyClient.getInstance(100, "Tech Corp", "12345678A", 30);
    }

    @Test
    void testGetInstanceValid() {
        assertDoesNotThrow(() -> {
            companyClient = CompanyClient.getInstance(100, "Tech Corp", "12345678A", 30);
        });
}

    @Test
    void testGetInstanceWithInvalidWorkers() {
        try {
            CompanyClient.getInstance(-100, "Tech Corp", "12345678A", 30);
            fail("Expected BuildException due to invalid number of workers");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Workers"));
        }
    }

    @Test
    void testGetInstanceWithInvalidSocialReason() {
        try {
            CompanyClient.getInstance(100, "Tec", "12345678A", 30);
            fail("Expected BuildException due to invalid Social Reason");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Social Reason"));
        }
    }

    @Test
    void testGetInstanceWithInvalidDNI() {
        try {
            CompanyClient.getInstance(100, "Tech Corp", "1234567", 30);
            fail("Expected BuildException due to invalid DNI");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad DNI"));
        }
    }

    @Test
    void testGetInstanceWithInvalidAge() {
        try {
            CompanyClient.getInstance(100, "Tech Corp", "12345678A", -30);
            fail("Expected BuildException due to invalid age");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Age"));
        }
    }

    @Test
    void testSetInvalidWorkers() {
        assertFalse(companyClient.setWorkers(-1));
    }

    @Test
    void testSetValidWorkers() {
        assertTrue(companyClient.setWorkers(50));
    }
    
    @Test
    void testSetInvalidSocialReason() {
        assertFalse(companyClient.setSocialReason(null));
        assertFalse(companyClient.setSocialReason(""));
        assertFalse(companyClient.setSocialReason("Tec"));
        assertFalse(companyClient.setSocialReason("T"));
    }
    
    @Test
    void testSetValidSocialReason() {
        assertTrue(companyClient.setSocialReason("Tech Corp"));
    }

    @Test
    void testGetCompanyType() {
        assertEquals("Medium Company", companyClient.getCompanyType());
    }

    @Test
    void testSetCompanyType() {
        companyClient.setCompanyType("Large Company");
        assertEquals("Large Company", companyClient.getCompanyType());
    }
}
