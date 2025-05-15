package com.example.softlearning_springboot.applicationcore.entity.book.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics.PhysicalData;

public class BookTest {

    private Book book;
    private PhysicalData physicalData;

    @BeforeEach
    void setUp() throws Checker.DateException, BuildException {
        book = new Book();
        book.setAuthor("Autor Correcto");
        book.setIsbn("1234567890123");
        book.setPages(100);
        book.setLanguages("Ingles");
        book.setDate_publicated("15-05-2024");
        book.setDate_disponibility("15-05-2024 12:00:00");
        physicalData = PhysicalData.getInstance(10.0, 5.0, 15.0, 20.0, false);
    }

    // ---------- TESTS DE CONSTRUCCIÓN ----------
    @Test
    void testGetInstanceCorrect() {
        assertDoesNotThrow(() -> {
            Book.getInstance("Libro Bueno", 20, "Descripción válida del libro", "Novela", "Ingles", "Autor Correcto",
                    "1234567890123", 100, "15-05-2024", "15-05-2024 12:00:00", 10, 10, 10, 1, false);
        });
    }

    @Test
    void testGetInstancewithInvalidAuthor() throws DateException {
        try {
            book.getInstance("Libro Bueno", 20, "Descripción válida del libro", "Novela", "Ingles", " ",
                    "1234567890123", 100, "15-05-2024", "15-05-2024 12:00:00", 10, 10, 10, 1, false);
            fail("Expected BuildException due to invalid author");
        } catch (BuildException e) {
            assertEquals("Failed to create Book: Bad author; ", e.getMessage());
        }
    }

    @Test
    void testGetInstancewithInvalidISBN() throws DateException {
        try {
            book.getInstance("Libro Bueno", 20, "Descripción válida del libro", "Novela", "Ingles", "Autore",
                    "123456789012113", 100, "15-05-2024", "15-05-2024 12:00:00", 10, 10, 10, 1, false);
            fail("Expected BuildException due to invalid iSBN");
        } catch (BuildException e) {
            assertEquals("Failed to create Book: Bad iSBN; ", e.getMessage());
        }
    }

    @Test
    void testGetInstancewithInvalidPages() throws DateException {
        try {
            book.getInstance("Libro Bueno", 20, "Descripción válida del libro", "Novela", "Ingles", "Autor Correcto",
                    "1234567890123", -100, "15-05-2024", "15-05-2024 12:00:00", 10, 10, 10, 1, false);
            fail("Expected BuildException due to invalid pages");
        } catch (BuildException e) {
            assertEquals("Failed to create Book: Bad pages; ", e.getMessage());
        }
    }

    @Test
    void testGetInstancewithInvalidDatePublicated() throws DateException {
        try {
            book.getInstance("Libro Bueno", 20, "Descripción válida del libro", "Novela", "Ingles", "Autor Correcto",
                    "1234567890123", 100, "152-05-2024", "15-05-2024 12:00:00", 10, 10, 10, 1, false);
            fail("Expected BuildException due to invalid publication date");
        } catch (BuildException e) {
            assertEquals("Failed to create Book: Bad publication date; ", e.getMessage());
        }
    }

    @Test
    void testGetInstancewithInvalidDateDisponibility() throws DateException {
        try {
            book.getInstance("Libro Bueno", 20, "Descripción válida del libro", "Novela", "Ingles", "Autor Correcto",
                    "1234567890123", 100, "14-05-2024", "153-05-2024 12:00:00", 10, 10, 10, 1, false);
            fail("Expected BuildException due to invalid availability date");
        } catch (BuildException e) {
            assertEquals("Failed to create Book: Bad availability date; ", e.getMessage());
        }
    }

    // ---------- AUTHOR ----------
    @Test
    void testSetAuthorCorrect() {
        assertTrue(book.setAuthor("Autor Correcto"));
    }

    @Test
    void testSetAuthorIncorrect() {
        assertFalse(book.setAuthor("abc"));
    }

    @Test
    void testSetAuthorNull() {
        assertFalse(book.setAuthor(null));
    }

    @Test
    void testSetAuthorVacio() {
        assertFalse(book.setAuthor(""));
    }

    @Test
    void testSetAuthorCero() {
        assertFalse(book.setAuthor("0"));
    }

    // ---------- ISBN ----------
    @Test
    void testSetIsbnCorrect() {
        assertTrue(book.setIsbn("1234567890123"));
    }

    @Test
    void testSetIsbnIncorrect() {
        assertFalse(book.setIsbn("123"));
    }

    @Test
    void testSetIsbnNull() {
        assertFalse(book.setIsbn(null));
    }

    @Test
    void testSetIsbnVacio() {
        assertFalse(book.setIsbn(""));
    }

    @Test
    void testSetIsbnCero() {
        assertFalse(book.setIsbn("0"));
    }

    @Test
    void testSetIsbnExcedeMax() {
        assertFalse(book.setIsbn("12345678901234567890"));
    }

    // ---------- PAGES ----------
    @Test
    void testSetPagesCorrect() {
        assertTrue(book.setPages(100));
    }

    @Test
    void testSetPagesIncorrect() {
        assertFalse(book.setPages(5));
    }

    @Test
    void testSetPagesCero() {
        assertFalse(book.setPages(0));
    }

    @Test
    void testSetPagesNegativo() {
        assertFalse(book.setPages(-1));
    }

    @Test
    void testSetPagesMinimo() {
        assertTrue(book.setPages(10));
    }

    @Test
    void testSetPagesMaximo() {
        assertTrue(book.setPages(Integer.MAX_VALUE));
    }

    // ---------- LANGUAGES ----------
    @Test
    void testSetLanguagesCorrect() {
        assertTrue(book.setLanguages("Ingles"));
    }

    @Test
    void testSetLanguagesIncorrect() {
        assertFalse(book.setLanguages("abc"));
    }

    @Test
    void testSetLanguagesNull() {
        assertFalse(book.setLanguages(null));
    }

    @Test
    void testSetLanguagesVacio() {
        assertFalse(book.setLanguages(""));
    }

    @Test
    void testSetLanguagesConEspacios() {
        assertFalse(book.setLanguages("In gl"));
    }

    // ---------- FECHAS PUBLICACION ----------
    @Test
    void testSetDatePublicatedCorrect() throws Checker.DateException {
        assertTrue(book.setDate_publicated("15-05-2024"));
    }

    @Test
    void testSetDatePublicatedFormatoIncorrecto() throws Checker.DateException {
        assertFalse(book.setDate_publicated("2024-05-15"));
    }

    @Test
    void testSetDatePublicatedNull() throws Checker.DateException {
        assertFalse(book.setDate_publicated(null));
    }

    @Test
    void testSetDatePublicatedVacio() throws Checker.DateException {
        assertFalse(book.setDate_publicated(""));
    }

    @Test
    void testSetDatePublicatedDiaTresDigitos() throws Checker.DateException {
        assertFalse(book.setDate_publicated("123-05-2024"));
    }

    @Test
    void testSetDatePublicatedMesTresDigitos() throws Checker.DateException {
        assertFalse(book.setDate_publicated("15-123-2024"));
    }

    @Test
    void testSetDatePublicatedAnioTresDigitos() throws Checker.DateException {
        assertFalse(book.setDate_publicated("15-05-123"));
    }

    // ---------- FECHAS DISPONIBILIDAD ----------
    @Test
    void testSetDateDisponibilityCorrect() throws Checker.DateException {
        assertTrue(book.setDate_disponibility("15-05-2024 12:00:00"));
    }

    @Test
    void testSetDateDisponibilityFormatoIncorrecto() throws Checker.DateException {
        assertFalse(book.setDate_disponibility("2024-05-15 12:00:00"));
    }

    @Test
    void testSetDateDisponibilityNull() throws Checker.DateException {
        assertFalse(book.setDate_disponibility(null));
    }

    @Test
    void testSetDateDisponibilityVacio() throws Checker.DateException {
        assertFalse(book.setDate_disponibility(""));
    }

    @Test
    void testSetDateDisponibilityDiaTresDigitos() throws Checker.DateException {
        assertFalse(book.setDate_disponibility("123-05-2024 12:00:00"));
    }

    @Test
    void testSetDateDisponibilityMesTresDigitos() throws Checker.DateException {
        assertFalse(book.setDate_disponibility("15-123-2024 12:00:00"));
    }

    @Test
    void testSetDateDisponibilityAnioTresDigitos() throws Checker.DateException {
        assertFalse(book.setDate_disponibility("15-05-123 12:00:00"));
    }

    // ---------- COPIAR PHYSICAL DATA ----------

    @Test
    void testGetFragile() {
        assertFalse(physicalData.getFragile());
    }

    @Test
    void testGetHigh() {
        assertEquals(10.0, physicalData.getHigh());
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

}