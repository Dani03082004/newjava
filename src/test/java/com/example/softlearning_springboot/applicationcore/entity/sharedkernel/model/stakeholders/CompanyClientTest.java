package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CompanyClientTest {

    @Test
    void testGetInstanceValid() {
        try {
            CompanyClient companyClient = CompanyClient.getInstance(100, "Tech Corp", "12345678A", 30);
            assertNotNull(companyClient);
        } catch (BuildException e) {
            fail("Error en el GetInstance de Company Client: " + e.getMessage());
        }
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
        CompanyClient companyClient = new CompanyClient();
        assertFalse(companyClient.setWorkers(-1));
    }

    @Test
    void testSetValidWorkers() {
        CompanyClient companyClient = new CompanyClient();
        assertTrue(companyClient.setWorkers(50));
    }
    
    @Test
    void testSetInvalidSocialReason() {
        CompanyClient companyClient = new CompanyClient();
        assertFalse(companyClient.setSocialReason(null)); 
    }
    
    @Test
    void testSetValidSocialReason() {
        CompanyClient companyClient = new CompanyClient();
        assertTrue(companyClient.setSocialReason("Tech Corp"));
    }

}
