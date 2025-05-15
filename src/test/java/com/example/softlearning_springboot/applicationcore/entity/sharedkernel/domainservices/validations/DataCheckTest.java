package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class DataCheckTest {

    // Funciones comprobación DNI

    @Test
    void testCheckDNIwithNull() {
        assertEquals(-1, DataCheck.checkDNI(null));
    }

    @Test
    void testCheckDNI() {
        assertEquals(0, DataCheck.checkDNI("12345678A"));
    }

    @Test
    void testValidarDNIWithInvalidDNI() {
        assertEquals(-1, DataCheck.checkDNI("12345678"));
    }

    @Test
    void testValidarDNIWithEmptyString() {
        assertEquals(-1, DataCheck.checkDNI(""));
    }

    @Test
    void testValidarDNIWithShortDNI() {
        assertEquals(-1, DataCheck.checkDNI("1234A"));
    }

    @Test
    void testValidarDNIWithLongDNI() {
        assertEquals(-1, DataCheck.checkDNI("123456789A"));
    }

    @Test
    void testDNIWithSpecialCharacters() {
        assertEquals(-1, DataCheck.checkDNI("1234!678A"));
    }

    // Funciones comprobación Email

    @Test
    void testCheckValidEmailFormat() {
        assertEquals(0, DataCheck.checkEmail("testunitjava@gmail.com"));
    }

    @Test
    void testCheckInvalidEmailFormat() {
        assertEquals(-1, DataCheck.checkEmail("t@tcom"));
    }

    @Test
    void testIsValidEmailFormatWithNull() {
        assertFalse(Checker.isValidEmailFormat(null));
    }

    @Test
    void testIsValidEmailFormatWithEmptyString() {
        assertFalse(Checker.isValidEmailFormat(""));
    }

    @Test
    void testIsValidEmailFormatWithInvalidEmailNoAtSymbol() {
        assertFalse(Checker.isValidEmailFormat("invalidemail.com"));
    }

    @Test
    void testIsValidEmailFormatWithInvalidEmailNoDomain() {
        assertFalse(Checker.isValidEmailFormat("user@"));
    }

    @Test
    void testIsValidEmailFormatWithInvalidEmailNoDotInDomain() {
        assertFalse(Checker.isValidEmailFormat("user@domain"));
    }

    @Test
    void testIsValidEmailFormatWithDoubleAt() {
        assertFalse(Checker.isValidEmailFormat("test@@gmail.com"));
    }

    @Test
    void testIsValidEmailFormatWithInvalidCharacters() {
        assertFalse(Checker.isValidEmailFormat("test!@gmail.com"));
    }

    // Con integers
    @Test
    void testCheckNumber() {
        assertEquals(0, DataCheck.checkNumber(9, 9));
    }

    @Test
    void testCheckBadNumber() {
        assertEquals(-1, DataCheck.checkNumber(3, 9));
    }

    @Test
    void testCheckNumberWithZero() {
        assertEquals(-1, DataCheck.checkNumber(0, 9));
    }

    // Con doubles
    @Test
    void testCheckBadNumber2() {
        assertEquals(-1, DataCheck.checkNumber(3.0, 9.0));
    }

    @Test
    void testCheckNumber2() {
        assertEquals(0, DataCheck.checkNumber(9.0, 9.0));
    }

    // Strings

    @Test
    void testCheckString() {
        assertEquals(-1, DataCheck.checkString("Hi", 3));
    }

    @Test
    void testCheckGoodString() {
        assertEquals(0, DataCheck.checkString("Buenas", 3));
    }

    @Test
    void testCheckStringWithNull() {
        assertEquals(-1, DataCheck.checkString(null, 3));
    }

    @Test
    void testCheckStringWithEmpty() {
        assertEquals(-1, DataCheck.checkString("", 3));
    }

    @Test
    void testCheckStringAtExactLength() {
        assertEquals(0, DataCheck.checkString("Hey", 3));
    }

    // Fechas

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
    void testConvertStringToDateTime() {
        LocalDateTime expectedDateTime = LocalDateTime.of(2025, 3, 21, 10, 0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String answerdatetime = expectedDateTime.format(formatter);
        assertTrue(answerdatetime.equals("2025-03-21 10:00:00"));
    }

    @Test
    void testConvertStringToBadDateTime() {
        LocalDateTime expectedDateTime = LocalDateTime.of(2025, 3, 20, 10, 0, 0);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String answerdatetime = expectedDateTime.format(formatter);
        assertFalse(answerdatetime.equals("2025-03-21 10:00:00"));
    }

    // Fechas con casos extremos y formatos inválidos

    @Test
    void testLeapYearDateValid() {
        LocalDate date = LocalDate.of(2024, 2, 29); // Año bisiesto
        assertEquals(29, date.getDayOfMonth());
    }

    @Test
    void testLeapYearDateInvalid() {
        assertThrows(java.time.DateTimeException.class, () -> {
            LocalDate.of(2023, 2, 29); // No es año bisiesto
        });
    }

    @Test
    void testDateWithThreeDigitDay() {
        assertThrows(java.time.format.DateTimeParseException.class, () -> {
            LocalDate.parse("2025-03-123", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        });
    }

    @Test
    void testDateWithThreeDigitMonth() {
        assertThrows(java.time.format.DateTimeParseException.class, () -> {
            LocalDate.parse("2025-123-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        });
    }

    @Test
    void testDateWithFiveDigitYear() {
        assertThrows(java.time.format.DateTimeParseException.class, () -> {
            LocalDate.parse("10000-03-10", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        });
    }
}
