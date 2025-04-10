package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;

// AssertTrue para comprobar si es verdadero, utiliza boleano
// AssertFalse para comprobar si es falso, utiliza boleano
// AssertEquals para comparar valores, utiliza valores
// 0 --> BUENO
// -1 --> MALO

class CheckerTest {

    // Funciones comprobación NotNegative
    @Test
    void testNegative() {
        assertEquals(-1, Checker.NotNegative(-5));
    }

    @Test
    void testPositive() {
        assertEquals(0, Checker.NotNegative(5));
    }

    @Test
    void testNotNegativeWithZero() {
        assertEquals(0, Checker.NotNegative(0));
    }

    @Test
    void testNotNegativeExceedMinRange() {
        assertEquals(-1, Checker.NotNegative(Integer.MIN_VALUE));
    }

    @Test
    void testNotNegativeExceedMaxRange() {
        assertEquals(0, Checker.NotNegative(Integer.MAX_VALUE));
    }

    // Funciones comprobación NotNullEmptyString

    @Test
    void testNotNullEmptyStringWithSpaces() {
        assertEquals(0, Checker.NotNullEmptyString("   "));
    }

    @Test
    void testNotNullEmptyStringWithEmptyString() {
        assertEquals(-2, Checker.NotNullEmptyString(""));
    }

    @Test
    void testNotNullString() {
        assertEquals(0, Checker.NotNullEmptyString("TestUnit"));
    }

    @Test
    void testNullEmptyString() {
        assertEquals(-1, Checker.NotNullEmptyString(null));
    }

    @Test
    void testNotNullEmptyStringExceedMinRange() {
        assertEquals(-2, Checker.NotNullEmptyString(""));
    }

    @Test
    void testNotNullEmptyStringExceedMaxRange() {
        String longString = "a".repeat(1000);
        assertEquals(0, Checker.NotNullEmptyString(longString));
    }

    // Funciones comprobación Password

    @Test
    void testPasswordMinLengthCorrect() {
        assertEquals(0, Checker.PasswordMinLength("alumnat", 5));
    }

    @Test
    void testPasswordNotMinLengthIncorrect() {
        assertEquals(-1, Checker.PasswordMinLength("al", 3));
    }

    @Test
    void testPasswordMinLengthWithNull() {
        assertEquals(-1, Checker.PasswordMinLength(null, 5));
    }

    @Test
    void testPasswordMinLengthWithEmptyString() {
        assertEquals(-1, Checker.PasswordMinLength("", 5));
    }

    @Test
    void testPasswordMinLengthExceedMinRange() {
        assertEquals(-1, Checker.PasswordMinLength("abc", 5));
    }

    // Funciones comprobación Fechas --> año + mes + dia

    @Test
    void testCheckDate() throws DateException {
        LocalDate fecha = Checker.checkDate("2025-03-20");
        String resultadofecha = fecha.toString();
        assertEquals("2025-03-20", resultadofecha);
    }

    @Test
    void testCheckBadDate() {
        assertThrows(DateException.class, () -> {
            Checker.checkDate("invalid-date");
        });
    }

    @Test
    void testCheckDateWithValidLeapYear() throws Checker.DateException {
        LocalDate date = Checker.checkDate("2024-02-29");
        assertEquals(LocalDate.of(2024, 2, 29), date);
    }

    @Test
    void testCheckDateWithInvalidLeapYear() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDate("2023-02-29");
        });
    }

    @Test
    void testCheckDateWithEmptyString() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDate("");
        });
    }

    @Test
    void testCheckDateWithNull() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDate(null);
        });
    }

    @Test
    void testCheckDateWithInvalidDay() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDate("2023-02-230");
        });
    }

    @Test
    void testCheckDateWithInvalidMonth() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDate("2023-113-01");
        });
    }

    @Test
    void testCheckDateWithInvalidYear(){
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDate("20213-01-01");
        });
    }

    @Test
    void testCheckDateWithInvalidFormat() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDate("2023/01/01");
        });
    }

    // Funciones comprobación Fechas --> año + mes + dia + horas + minutos + segundos

    @Test
    void testCheckDateTime() throws DateException {
        LocalDateTime fechahora = Checker.checkDateTime("2025-03-20 10:00:00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String resultadofechahora = fechahora.format(formatter);
        assertEquals("2025-03-20 10:00:00", resultadofechahora);
    }

    @Test
    void testCheckBadDateTime() {
        assertThrows(DateException.class, () -> {
            Checker.checkDateTime("invalid-datetime");
        });
    }

    @Test
    void testCheckDateTimeWithValidLeapYear() throws Checker.DateException {
        LocalDateTime date = Checker.checkDateTime("2024-02-29 10:00:00");
        assertEquals(LocalDateTime.of(2024, 2, 29, 10, 00, 00), date);
    }

    @Test
    void testCheckDateTimeWithInvalidLeapYear() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTime("2023-02-29 10:00:00");
        });
    }

    @Test
    void testCheckDateTimeWithEmptyString() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTime("");
        });
    }

    @Test
    void testCheckDateTimeWithNull() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTime(null);
        });
    }

    @Test
    void testCheckDateTimeWithInvalidDay() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTime("2023-02-230 10:00:00");
        });
    }

    @Test
    void testCheckDateTimeWithInvalidMonth() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTime("2023-113-01 10:00:00");
        });
    }

    @Test
    void testCheckDateTimeWithInvalidYear(){
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTime("20213-01-01 10:00:00");
        });
    }

    @Test
    void testCheckDateTimeWithInvalidFormat() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTime("2023/01/01 10:00:00");
        });
    }

    @Test
    void testCheckDateTimes() throws DateException {
        LocalDateTime datehour = Checker.checkDateTimes("19-03-2025 10:00:00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String resultadofechahora = datehour.format(formatter);
        assertEquals("19-03-2025 10:00:00", resultadofechahora);
    }

    @Test
    void testCheckBadDateTimes() {
        assertThrows(DateException.class, () -> {
            Checker.checkDateTimes("invalid-datetime");
        });
    }

    @Test
    void testCheckDateTimesWithValidLeapYear() throws Checker.DateException {
        LocalDateTime date = Checker.checkDateTimes("29-02-2024 10:00:00");
        assertEquals(LocalDateTime.of(2024, 2, 29, 10, 00, 00), date);
    }

    @Test
    void testCheckDateTimesWithInvalidLeapYear() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTimes("29-02-2023 10:00:00");
        });
    }

    @Test
    void testCheckDateTimesWithEmptyString() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTimes("");
        });
    }

    @Test
    void testCheckDateTimesWithNull() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTimes(null);
        });
    }

    @Test
    void testCheckDateTimesWithInvalidDay() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTimes("223-02-2023 10:00:00");
        });
    }

    @Test
    void testCheckDateTimesWithInvalidMonth() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTimes("01-113-2023");
        });
    }

    @Test
    void testCheckDateTimesWithInvalidYear(){
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTimes("01-01-20213");
        });
    }

    @Test
    void testCheckDateTimesWithInvalidFormat() {
        assertThrows(Checker.DateException.class, () -> {
            Checker.checkDateTimes("01/01/2023 10:00:00");
        });
    }

    // Funciones comprobación Espacios

    @Test
    void testHasSpaces() {
        assertTrue(Checker.hasSpaces("Test Unit"));
    }

    @Test
    void testNoSpaces() {
        assertFalse(Checker.hasSpaces("Testunit"));
    }

    // Función comprobación MinLength

    @Test
    void testMinLengthWithEmptyString() {
        assertFalse(Checker.minLength("", 3));
    }

    @Test
    void testMinLengthWithSpaces() {
        assertFalse(Checker.minLength("  ", 3));
    }

    // Funciones comprobación isInt or NegativeInt

    @Test
    void testIsInt() {
        assertTrue(Checker.isInt(123));
    }

    @Test
    void testIsNegativeInt() {
        assertTrue(Checker.isNegativeInt(-3));
    }

    @Test
    void testIsNotegativeInt() {
        assertFalse(Checker.isNegativeInt(3));
    }

    // Función comprobación Email

    @Test
    void testIsValidEmailFormat() {
        assertTrue(Checker.isValidEmailFormat("tunit@gmail.com"));
    }

    @Test
    void testIsNotValidEmailFormat() {
        assertTrue(Checker.isValidEmailFormat("t@jpa.com"));
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

    // Función comprobación isZero

    @Test
    void testIsZero() {
        assertEquals(0, Checker.isZero(0));
    }

    @Test
    void testIsNotZero() {
        assertEquals(-1, Checker.isZero(1));
    }

    @Test
    void testMinLength() {
        assertTrue(Checker.minLength("Java", 3));
    }

    @Test
    void testNotMinLength() {
        assertFalse(Checker.minLength("Ja", 3));
    }

    @Test
    void testNotNullWithNull() {
        assertEquals(-1, Checker.NotNull(null));
    }

    @Test
    void testMinLengthWithNull() {
        assertFalse(Checker.minLength(null, 3));
    }

    @Test
    void testMinValue() {
        assertEquals(0, (Checker.minValue(10, 5)));
    }

    @Test
    void testNonNegative() {
        assertEquals(0, Checker.nonNegative(8));
    }

    @Test
    void testAndNegative() {
        assertEquals(-1, Checker.nonNegative(-8));
    }

    @Test
    void testValidarDNI() {
        assertEquals(0, Checker.validarDNI("12345678A"));
    }

    @Test
    void testValidarBadDNI() {
        assertEquals(-1, Checker.validarDNI("12345678"));
    }
}
