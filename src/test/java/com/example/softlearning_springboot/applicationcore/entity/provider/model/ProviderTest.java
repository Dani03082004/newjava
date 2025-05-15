package com.example.softlearning_springboot.applicationcore.entity.provider.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ProviderTest {

    private Provider provider;

    @BeforeEach
    public void setUp() throws BuildException {
        provider = Provider.getInstance("morning", "journalist", "journalist", "secret123", 50, "journalist", 1, "hese",
                "calle A", "hombre", 123456789, 10291, "esehombre@gmail.com", "1990-01-01");
    }

    @Test
    void testGetInstanceValid() {
        try {
            provider.getInstance("morning", "journalist", "journalist", "secret123", 10, "journalist", 1, "hese",
                    "calle A", "hombre", 123456789, 10291, "esehombre@gmail.com", "1990-01-01");
            assertNotNull(provider);
        } catch (BuildException e) {
            fail("Error en el GetInstance de Provider: " + e.getMessage());
        }
    }

    @Test
    void testGetInstanceInvalidSchedule() {
        try {
            provider.getInstance("morning shift with spaces", "journalist", "journalist", "secret123", 10, "journalist",
                    1, "hese", "calle A", "hombre", 123456789, 10291, "esehombre@gmail.com", "1990-01-01");
            fail("Expected BuildException due to invalid schedule");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Schedule"));
        }
    }

    @Test
    void testGetInstanceInvalidWork() {
        try {
            provider.getInstance("morning", "sho", "journalist", "secret123", 10, "journalist", 1, "hese", "calle A",
                    "hombre", 123456789, 10291, "esehombre@gmail.com", "1990-01-01");
            fail("Expected BuildException due to invalid work");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Work"));
        }
    }

    @Test
    void testGetInstanceInvalidUser() {
        try {
            provider.getInstance("morning", "journalist", "usr", "secret123", 10, "journalist", 1, "hese", "calle A",
                    "hombre", 123456789, 10291, "esehombre@gmail.com", "1990-01-01");
            fail("Expected BuildException due to invalid user");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad User"));
        }
    }

    @Test
    void testGetInstanceInvalidPassword() {
        try {
            provider.getInstance("morning", "journalist", "journalist", "123", 10, "journalist", 1, "hese", "calle A",
                    "hombre", 123456789, 10291, "esehombre@gmail.com", "1990-01-01");
            fail("Expected BuildException due to invalid password");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Password"));
        }
    }

    @Test
    void testValidSetSchedule() {
        assertTrue(provider.setSchedule("afternoon"));
    }

    @Test
    void testInvalidSetSchedule() {
        assertFalse(provider.setSchedule("afternoon shift with spaces"));
        assertFalse(provider.setSchedule(""));
        assertFalse(provider.setSchedule(null));
    }

    @Test
    void testGetSchedule() {
        assertEquals("morning", provider.getSchedule());
    }

    @Test
    void testValidSetWork() {
        assertTrue(provider.setWork("editor"));
    }

    @Test
    void testInvalidSetWork() {
        assertFalse(provider.setWork(""));
        assertFalse(provider.setWork("shor"));
        assertFalse(provider.setWork("editor with spaces"));
        assertFalse(provider.setWork(null));
    }

    @Test
    void testGetWork() {
        assertEquals("journalist", provider.getWork());
    }

    @Test
    void testValidSetUser() {
        assertTrue(provider.setUser("newuser"));
    }

    @Test
    void testInvalidSetUser() {
        assertFalse(provider.setUser("usr"));
        assertFalse(provider.setUser(""));
        assertFalse(provider.setUser(null));
    }

    @Test
    void testGetUser() {
        assertEquals("journalist", provider.getUser());
    }

    @Test
    void testValidSetPassword() {
        assertTrue(provider.setPassword("newpassword123"));
    }

    @Test
    void testInvalidSetPassword() {
        assertFalse(provider.setPassword("short")); 
        assertFalse(provider.setPassword(""));
        assertFalse(provider.setPassword(null));
    }

    @Test
    void testGetPassword() {
        assertEquals("secret123", provider.getPassword());
    }

    @Test
    void testProviderToString() {
        String expected = "Provider [work=journalist, user=journalist]";
        assertEquals(expected, provider.toString());
    }
    
    @Test
    void testGetData() {
        String expectedData = "Información del Proveedor: horario: morning, trabajo: journalist, usuario: journalist, contraseña: secret123, empresa: Medium Company, número de trabajadores: 50, razón social: journalist";
        assertEquals(expectedData, provider.getData());
    }
    
    
}
