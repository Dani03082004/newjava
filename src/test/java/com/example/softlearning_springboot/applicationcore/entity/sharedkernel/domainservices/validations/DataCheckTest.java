package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

// AssertTrue para comprobar si es verdadero, utiliza boleano
// AssertFalse para comprobar si es falso, utiliza boleano
// AssertEquals para comparar valores, utiliza valores
// 0 --> BUENO
// -1 --> MALO


public class DataCheckTest {
    @Test
    void testCheckBadDNI() {
        assertEquals(-1, DataCheck.checkDNI(null));
    }

    @Test
    void testCheckDNI() {
        assertEquals(0, DataCheck.checkDNI("12345678A"));
    }

    @Test
    void testCheckEmail() {
        assertEquals(0, DataCheck.checkEmail("testunitjava@gmail.com"));
    }

    @Test
    void testCheckBadEmail() {
        assertEquals(-1, DataCheck.checkEmail("t@t.com"));
    }

    // Con integers
    @Test
    void testCheckNumber() {
        assertEquals(0, DataCheck.checkNumber(9, 9));
    }

    // Con integers
    @Test
    void testCheckBadNumber() {
        assertEquals(-1, DataCheck.checkNumber(3, 9));
    }

    // Con doubles
    @Test
    void testCheckBadNumber2() {
        assertEquals(-1, DataCheck.checkNumber(3, 9));
    }

    // Con doubles
    @Test
    void testCheckNumber2() {
        assertEquals(0, DataCheck.checkNumber(9, 9));
    }

    @Test
    void testCheckString() {
        assertEquals(-1, DataCheck.checkString("Hi", 3));
    }

    @Test
    void testCheckGoodString() {
        assertEquals(0, DataCheck.checkString("Buenas", 3));
    }

    @Test
    void testConvertStringToDate() {
        LocalDate expectedDate = LocalDate.of(2025, 3, 20);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String answerdate = expectedDate.format(formatter);
        assertTrue(answerdate.equals("2025-03-20"));
    }

    @Test
    void testConvertStringToBadDate() {
        LocalDate expectedDate = LocalDate.of(2025, 3, 20);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String answerdate = expectedDate.format(formatter);
        assertFalse(answerdate.equals("2025-03-21"));
    }

    @Test
    void testConvertStringToBadDateTime() {
        LocalDateTime expectedDateTime = LocalDateTime.of(2025, 3, 20, 10, 0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String answerdatetime = expectedDateTime.format(formatter);
        assertFalse(answerdatetime.equals("2025-03-21 10:00:00"));
    }

    @Test
    void testConvertStringToDateTime() {
        LocalDateTime expectedDateTime = LocalDateTime.of(2025, 3, 21, 10, 0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String answerdatetime = expectedDateTime.format(formatter);
        assertTrue(answerdatetime.equals("2025-03-21 10:00:00"));
    }
}
