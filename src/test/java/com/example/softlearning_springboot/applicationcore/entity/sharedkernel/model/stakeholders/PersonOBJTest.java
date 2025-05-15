package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PersonOBJTest {

    private PersonOBJ personOBJ;

    // Importar con el SetUp
    // El Set y el Get tal cual como estan aqui

    @BeforeEach
    public void setUp() throws BuildException {
        personOBJ = new PersonOBJ();
        personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 648473821, 84839, "pericodelgado@gmail.com",
                "11-11-1990");
    }

    @Test
    void testGetInstanceValid() {
        assertDoesNotThrow(() -> {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 648473821, 84839,
                    "pericodelgado@gmail.com", "11-11-1990");
        });
    }

    @Test
    void testGetInstancewithInvalidId() {
        try {
            personOBJ.CheckPersonData(-1, "Perico", "Calle Perico", "Delgado", 648473821, 84839,
                    "pericodelgado@gmail.com", "11-11-1990");
            fail("Expected BuildException due to invalid id");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad ID"));
        }
    }

    @Test
    void testGetInstancewithInvalidName() {
        try {
            personOBJ.CheckPersonData(1, "O", "Calle Perico", "Delgado", 648473821, 84839, "pericodelgado@gmail.com",
                    "11-11-1990");
            fail("Expected BuildException due to invalid name");
        } catch (BuildException e) {
            assertEquals("Not possible to create the object: Bad name; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithEmptyName() {
        Exception exception = assertThrows(BuildException.class, () -> {
            personOBJ.CheckPersonData(1, "", "Calle Perico", "Delgado", 648473821, 84839, "pericodelgado@gmail.com",
                    "11-11-1990");
        });
        assertEquals("Not possible to create the object: Bad name; ", exception.getMessage());
    }

    @Test
    void testGetInstanceWithShortName() {
        Exception exception = assertThrows(BuildException.class, () -> {
            personOBJ.CheckPersonData(1, "A", "Calle Perico", "Delgado", 648473821, 84839, "pericodelgado@gmail.com",
                    "11-11-1990");
        });
        assertEquals("Not possible to create the object: Bad name; ", exception.getMessage());
    }

    @Test
    void testGetInstancewithInvalidAddress() {
        try {
            personOBJ.CheckPersonData(1, "Perico", null, "Delgado", 648473821, 84839, "pericodelgado@gmail.com",
                    "11-11-1990");
            fail("Expected BuildException due to invalid address");
        } catch (BuildException e) {
            assertEquals("Not possible to create the object: Bad address; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithNullAddress() {
        Exception exception = assertThrows(BuildException.class, () -> {
            personOBJ.CheckPersonData(1, "Perico", null, "Delgado", 648473821, 84839, "pericodelgado@gmail.com",
                    "11-11-1990");
        });
        assertEquals("Not possible to create the object: Bad address; ", exception.getMessage());
    }

    @Test
    void testGetInstancewithInvalidSurname() {
        try {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", " ", 648473821, 84839, "pericodelgado@gmail.com",
                    "11-11-1990");
            fail("Expected BuildException due to invalid Surname");
        } catch (BuildException e) {
            assertEquals("Not possible to create the object: Bad cognoms; ", e.getMessage());
        }
    }

    @Test
    void testGetInstancewithInvalidPhoneNumber() {
        try {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 0, 84839, "pericodelgado@gmail.com",
                    "11-11-1990");
            fail("Expected BuildException due to invalid phone number");
        } catch (BuildException e) {
            assertEquals("Not possible to create the object: Bad phone number; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithZeroPhoneNumber() {
        Exception exception = assertThrows(BuildException.class, () -> {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 0, 84839, "pericodelgado@gmail.com",
                    "11-11-1990");
        });
        assertEquals("Not possible to create the object: Bad phone number; ", exception.getMessage());
    }

    @Test
    void testGetInstancewithInvalidPostalCode() {
        try {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 648473821, -1, "pericodelgado@gmail.com",
                    "11-11-1990");
            fail("Expected BuildException due to invalid Postal Code");
        } catch (BuildException e) {
            assertEquals("Not possible to create the object: Bad postal code; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithNegativePostalCode() {
        Exception exception = assertThrows(BuildException.class, () -> {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 648473821, -1, "pericodelgado@gmail.com",
                    "11-11-1990");
        });
        assertEquals("Not possible to create the object: Bad postal code; ", exception.getMessage());
    }

    @Test
    void testGetInstancewithInvalidEmail() {
        try {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 648473821, 8, "p", "11-11-1990");
            fail("Expected BuildException due to invalid Email");
        } catch (BuildException e) {
            assertEquals("Not possible to create the object: Bad email; ", e.getMessage());
        }
    }

    @Test
    void testGetInstancewithInvalidBirthday() {
        try {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 648473821, 8, "pericodelgado@gmail.com",
                    "bad");
            fail("Expected BuildException due to invalid Birthday");
        } catch (BuildException e) {
            assertEquals("Not possible to create the object: Bad birthday; ", e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithNullBirthday() {
        Exception exception = assertThrows(BuildException.class, () -> {
            personOBJ.CheckPersonData(1, "Perico", "Calle Perico", "Delgado", 648473821, 84839,
                    "pericodelgado@gmail.com", null);
        });
        assertEquals("Not possible to create the object: Bad birthday; ", exception.getMessage());
    }

    @Test
    void testGetInstanceInvalidValues() {
        Exception exception = assertThrows(BuildException.class, () -> {
            personOBJ.CheckPersonData(-1, null, null, null, -61, -8, "pm", null);
        });
        assertEquals(
                "Not possible to create the object: Bad ID; Bad name; Bad address; Bad cognoms; Bad phone number; Bad postal code; Bad email; Bad birthday; ",
                exception.getMessage());
    }

    @Test
    void testGetAddress() {
        assertEquals("Calle Perico", personOBJ.getAddress());
    }

    @Test
    void testGetBirthday() {
        assertEquals("11-11-1990", personOBJ.getBirthday());
    }

    @Test
    void testGetCognoms() {
        assertEquals("Delgado", personOBJ.getCognoms());
    }

    @Test
    void testGetEmail() {
        assertEquals("pericodelgado@gmail.com", personOBJ.getEmail());
    }

    @Test
    void testGetId() {
        assertEquals(1, personOBJ.getId());
    }

    @Test
    void testGetName() {
        assertEquals("Perico", personOBJ.getName());
    }

    @Test
    void testGetPhoneNumber() {
        assertEquals(648473821, personOBJ.getPhoneNumber());
    }

    @Test
    void testGetPostalCode() {
        assertEquals(84839, personOBJ.getPostalCode());
    }

    @Test
    void testSetAddressValid() {
        assertTrue(personOBJ.setAddress("Calle Perico"));
    }

    @Test
    void testSetAddressInValid() {
        assertFalse(personOBJ.setAddress(null));
    }

    @Test
    void testSetAddressEmpty() {
        assertFalse(personOBJ.setAddress(""));
    }

    @Test
    void testSetBirthdayValid() {
        assertTrue(personOBJ.setBirthday("11-11-1990"));
    }

    @Test
    void testSetBirthdayInvalid() {
        assertFalse(personOBJ.setBirthday(null));
    }

    @Test
    void testSetBirthdayEmpty() {
        assertFalse(personOBJ.setBirthday(""));
    }

    @Test
    void testSetBirthdayValidFormat() {
        assertTrue(personOBJ.setBirthday("11-11-1990")); 
        assertTrue(personOBJ.setBirthday("01-01-2000")); 
    }

    @Test
    void testSetBirthdayInvalidDay() {
        assertFalse(personOBJ.setBirthday("32-01-1990")); 
        assertFalse(personOBJ.setBirthday("00-01-1990")); 
        assertFalse(personOBJ.setBirthday("111-01-1990")); 
    }

    @Test
    void testSetBirthdayInvalidMonth() {
        assertFalse(personOBJ.setBirthday("11-13-1990")); 
        assertFalse(personOBJ.setBirthday("11-00-1990")); 
        assertFalse(personOBJ.setBirthday("11-111-1990")); 
    }

    @Test
    void testSetBirthdayInvalidYear() {
        assertFalse(personOBJ.setBirthday("11-11-99")); 
        assertFalse(personOBJ.setBirthday("11-11-199")); 
        assertFalse(personOBJ.setBirthday("11-11-19900")); 
    }

    @Test
    void testSetBirthdayInvalidFormat() {
        assertFalse(personOBJ.setBirthday("1990-11-11")); 
        assertFalse(personOBJ.setBirthday("11/11/1990")); 
        assertFalse(personOBJ.setBirthday("11.11.1990")); 
        assertFalse(personOBJ.setBirthday("11-11-90")); 
    }

    @Test
    void testSetBirthdayEmptyOrNull() {
        assertFalse(personOBJ.setBirthday("")); 
        assertFalse(personOBJ.setBirthday(null)); 
    }

    @Test
    void testSetCognomsValid() {
        assertTrue(personOBJ.setCognoms("Delgado"));
    }

    @Test
    void testSetCognomInvalid() {
        assertFalse(personOBJ.setCognoms("D"));
        assertFalse(personOBJ.setCognoms(" "));
        assertFalse(personOBJ.setCognoms(null));
        assertFalse(personOBJ.setCognoms(""));
        
    }

    @Test
    void testSetEmailValid() {
        assertTrue(personOBJ.setEmail("pericodelgado@gmail.com"));
    }

    @Test
    void testSetEmailInvalid() {
        assertFalse(personOBJ.setEmail(" "));
        assertFalse(personOBJ.setEmail(null));
        assertFalse(personOBJ.setEmail("pericodelgado@gmail"));
        assertFalse(personOBJ.setEmail("pericodelgado@.com"));
        assertFalse(personOBJ.setEmail("pericodelgado@gmail..com"));
        assertFalse(personOBJ.setEmail("pericodelgado@gmail@com"));
        assertFalse(personOBJ.setEmail("pericodelgado@gmail,com"));
        assertFalse(personOBJ.setEmail("pericodelgado@gmail@com"));

    }

    @Test
    void testSetIdValid() {
        assertTrue(personOBJ.setId(1));
    }

    @Test
    void testSetIdInvalid() {
        assertFalse(personOBJ.setId(-1));
    }

    @Test
    void testSetNameValid() {
        assertTrue(personOBJ.setName("Perico"));
    }

    @Test
    void testSetNameInvalid() {
        assertFalse(personOBJ.setName("P"));
        assertFalse(personOBJ.setName(" "));
        assertFalse(personOBJ.setName(null));
    }

    @Test
    void testSetPhoneNumberValid() {
        assertTrue(personOBJ.setPhoneNumber(648473821));
    }

    @Test
    void testSetPhoneNumberInvalid() {
        assertFalse(personOBJ.setPhoneNumber(-1));
    }

    @Test
    void testSetPostalCodeValid() {
        assertTrue(personOBJ.setPostalCode(84839));
    }

    @Test
    void testSetPostalCodeInvalid() {
        assertFalse(personOBJ.setPostalCode(-8));
    }

    @Test
    void testGetContactData() {
        personOBJ.setId(1);
        personOBJ.setName("Perico");
        personOBJ.setCognoms("Delgado");
        assertEquals("PersonOBJ [id=1, name=Perico, cognoms=Delgado]", personOBJ.toString());
    }
}
