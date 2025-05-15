package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CompanyDataTest {

    private CompanyData companyData;

    @BeforeEach
    public void setUp() throws BuildException {
        this.companyData = new CompanyData(100, "Tech Corp");
    }

    @Test
    void testGetInstanceValid() {
        assertDoesNotThrow(() -> {
            companyData = new CompanyData(100, "Tech Corp");
        });
    }

    @Test
    void testCompanyDatawithInvalidWorkers() {
        try {
            companyData = new CompanyData(-100, "Tech Corp");
            fail("Expected BuildException due to invalid Workers");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Workers"));
        }
    }

    @Test
    void testCompanyDatawithInvalidSocialReason() {
        try {
            companyData = new CompanyData(100, "Tec");
            fail("Expected BuildException due to invalid Social Reason");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Social Reason"));
        }
    }

    @Test
    void testGetWorkers() throws BuildException {
        assertEquals(100, companyData.getWorkers());
    }

    @Test
    void testGetSocialReason() {
        assertEquals("Tech Corp", companyData.getSocialreason());
    }

    @Test
    void testSetInvalidWorkers() {
        assertFalse(companyData.setWorkers(-100));
    }

    @Test
    void testSetValidWorkers() {
        assertTrue(companyData.setWorkers(100));
    }

    @Test
    void testSetValidSocialReason() {
        assertTrue(companyData.setSocialReason("Tech Corp"));
    }

    @Test
    void testSetInvalidSocialReason() {
        assertFalse(companyData.setSocialReason(null));
        assertFalse(companyData.setSocialReason(""));
        assertFalse(companyData.setSocialReason("Tec"));
        assertFalse(companyData.setSocialReason("T"));
    }

    @Test
    void testGetCompanyType() {
        try {
            companyData = new CompanyData(100, "Tech Corp");
            assertEquals("Medium Company", companyData.getCompanytype());
        } catch (BuildException e) {
            fail("Bad CompanyData: " + e.getMessage());
        }
    }

    @Test
    void testSetValidWorkersBigCompany() {
        try {
            companyData = new CompanyData(300, "Tech Corp");
            assertEquals("Big Company", companyData.getCompanytype());
        } catch (BuildException e) {
            fail("Bad CompanyData: " + e.getMessage());
        }
    }

    @Test
    void testSetValidWorkersSmallCompany() {
        try {
            companyData = new CompanyData(30, "Tech Corp");
            assertEquals("Small Company", companyData.getCompanytype());
        } catch (BuildException e) {
            fail("Bad CompanyData: " + e.getMessage());
        }
    }

    @Test
    void testSetValidWorkersMediumCompany() {
        try {
            companyData = new CompanyData(100, "Tech Corp");
            assertEquals("Medium Company", companyData.getCompanytype());
        } catch (BuildException e) {
            fail("Bad CompanyData: " + e.getMessage());
        }
    }
}
