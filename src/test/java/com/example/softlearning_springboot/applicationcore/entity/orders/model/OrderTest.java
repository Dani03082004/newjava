package com.example.softlearning_springboot.applicationcore.entity.orders.model;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OrderTest {

    private Order first_order;
    private Order second_order;

    @BeforeEach
    void setUp() throws Exception {
        first_order = Order.getInstance(
                1, "Calle Correcta", "Persona Correcta", "666666666",
                123, "Valid description for order", "15/05/2024 12:00:00");
        second_order = Order.getInstance(12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
    }

    // ---------- PRIMER TEST DE CONSTRUCCIÓN ----------
    @Test
    void testGetInstanceCorrect() {
        assertDoesNotThrow(() -> {
            first_order.getInstance(
                    1, "Calle Correcta", "Persona Correcta", "666666666",
                    123, "Descripción válida", "15/05/2024 12:00:00");
        });
    }

    @Test
    void testGetInstanceIncorrectClientID() throws BuildException, DateException {
        try {
            first_order.getInstance(
                    -1, "Calle Correcta", "Persona Correcta", "666666666",
                    123, "Descripción válida", "2024-05-15 12:00:00");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Client Id; "));
        }
    }

    @Test
    void testGetInstanceIncorrectReceiverAddress() throws BuildException, DateException {
        try {
            first_order.getInstance(
                    1, "abc", "Persona Correcta", "666666666",
                    123, "Descripción válida", "2024-05-15 12:00:00");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Receiver Address; "));
        }
    }

    @Test
    void testGetInstanceIncorrectReceiverPerson() throws DateException {
        Exception exception = assertThrows(BuildException.class, () -> {
            first_order.getInstance(
                    1, "Calle Correcta", " ", "666666666",
                    123, "Descripción válida", "2024-05-15 12:00:00");
        });
        assertTrue(exception.getMessage().contains("Bad Receiver Person"));
    }

    @Test
    void testGetInstanceIncorrectPhoneContact() throws BuildException, DateException {
        Exception exception = assertThrows(BuildException.class, () -> {
            first_order.getInstance(
                    1, "Calle Correcta", "Persona Correcta", " ",
                    123, "Descripción válida", "2024-05-15 12:00:00");
        });
        assertTrue(exception.getMessage().contains("Bad Phone Contact"));
    }

    // ---------- PRIMER TEST DE CONSTRUCCIÓN -- MÉTODOS DE OPERATION ----------

    @Test
    void testGetInstanceIncorrectInitDate() throws BuildException, DateException {
        try {
            first_order.getInstance(
                    1, "Calle Correcta", "Persona Correcta", "666666666",
                    123, "Descripción válida", "2024-05-15 12:00:00");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Init Date; "));
        }
    }

    @Test
    void testGetInstanceIncorrectDescription() throws BuildException, DateException {
        try {
            first_order.getInstance(
                    1, "Calle Correcta", "Persona Correcta", "666666666",
                    123, "", "2024-05-15 12:00:00");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Description; "));
        }
    }

    @Test
    void testGetInstanceIncorrectReference() throws BuildException, DateException {
        try {
            first_order.getInstance(
                    1, "Calle Correcta", "Persona Correcta", "666666666",
                    -1, "Descripción válida", "2024-05-15 12:00:00");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Reference; "));
        }
    }

    // ---------- SEGUNDO TEST DE CONSTRUCCIÓN ----------

    @Test
    void testGetInstanceCorrect2() {
        assertDoesNotThrow(() -> {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        });
    }

    @Test
    void testGetInstanceIncorrectClientID2() throws DateException, BuildException {  
        try {
            second_order.getInstance(
                    -1, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Client Id; "));
        }
    }

    @Test
    void testGetInstanceIncorrectReceiverAddress2() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "abc", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Receiver Address; "));
        }
    }

    @Test
    void testGetInstanceIncorrectReceiverPerson2() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", " ", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Receiver Person; "));
        }
    }

    @Test
    void testGetInstanceIncorrectPhoneContact2() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Phone Contact; "));
        }
    }

    @Test
    void testGetInstanceIncorrectInitDate2() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "2024-05-15 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Init Date; "));
        }
    }

    @Test
    void testGetInstanceIncorrectDescription2() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Description; "));
        }
    }

    @Test
    void testGetInstanceIncorrectReference2() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", -1,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Reference; "));
        }
    }

    @Test
    void testGetInstanceIncorrectPaymentDate() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "2024-05-15 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Payment Date; "));
        }
    }

    @Test
    void testGetInstanceIncorrectDeliveryDate() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "2024-05-15 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Delivery Date; "));
        }
    }

    @Test
    void testGetInstanceIncorrectFinishDate() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "2024-05-15 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Finish Date; "));
        }
    }

    @Test
    void testGetInstanceIncorrectShoppingCart() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    " ", "600123456", 30.5, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Shopping Cart; "));
        }
    }

    @Test
    void testGetInstanceIncorrectHigh() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", -1, 20.0, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad High; "));
        }
    }

    @Test
    void testGetInstanceIncorrectWidth() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, -1, 40.0, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Width; "));
        }
    }

    @Test
    void testGetInstanceIncorrectLength() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, -1, 3.5, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Length; "));
        }
    }

    @Test
    void testGetInstanceIncorrectWeight() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, -1, true);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Weight; "));
        }
    }

    @Test
    void testGetInstanceIncorrectFragile() throws DateException, BuildException {
        try {
            second_order.getInstance(
                    12345, "Calle Mayor, 123, Madrid", "Juan Pérez", 98765,
                    "Pedido de libros y material de oficina", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00", "15/05/2024 12:00:00",
                    "JAVA1,2,10,5,JAVA;JAVA2,2,10,5,JAVA2", "600123456", 30.5, 20.0, 40.0, 3.5, false);
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Fragile; "));
        }
    }

    // ---------- CLIENT ID ----------
    @Test
    void testSetClientIdCorrect() {
        assertTrue(first_order.setClientId(10));
    }

    @Test
    void testSetClientIdIncorrect() {
        assertFalse(first_order.setClientId(-1));
    }

    @Test
    void testSetClientIdCero() {
        assertFalse(first_order.setClientId(0));
    }

    // ---------- RECEIVER ADDRESS ----------
    @Test
    void testSetReceiverAddressCorrect() {
        assertTrue(first_order.setReceiveraddress("Calle Correcta"));
    }

    @Test
    void testSetReceiverAddressIncorrect() {
        assertFalse(first_order.setReceiveraddress("abc"));
    }

    @Test
    void testSetReceiverAddressNull() {
        assertFalse(first_order.setReceiveraddress(null));
    }

    @Test
    void testSetReceiverAddressVacio() {
        assertFalse(first_order.setReceiveraddress(""));
    }

    // ---------- RECEIVER PERSON ----------
    @Test
    void testSetReceiverPersonCorrect() {
        assertTrue(first_order.setReceiverPerson("Persona Correcta"));
    }

    @Test
    void testSetReceiverPersonIncorrect() {
        assertFalse(first_order.setReceiverPerson("abc"));
    }

    @Test
    void testSetReceiverPersonNull() {
        assertFalse(first_order.setReceiverPerson(null));
    }

    @Test
    void testSetReceiverPersonVacio() {
        assertFalse(first_order.setReceiverPerson(""));
    }

    // ---------- PHONE CONTACT ----------
    @Test
    void testSetPhoneContactCorrect() {
        assertTrue(first_order.setPhoneContact("666666666"));
    }

    @Test
    void testSetPhoneContactIncorrect() {
        assertFalse(first_order.setPhoneContact("123"));
    }

    @Test
    void testSetPhoneContactNull() {
        assertFalse(first_order.setPhoneContact(null));
    }

    @Test
    void testSetPhoneContactVacio() {
        assertFalse(first_order.setPhoneContact(""));
    }

    @Test
    void testSetPhoneContactMultipleCorrect() {
        assertTrue(first_order.setPhoneContact("666666666,777777777"));
    }

    @Test
    void testSetPhoneContactMultipleUnoIncorrecto() {
        assertFalse(first_order.setPhoneContact("666666666,123"));
    }

    // ---------- INITDATE ----------

    @Test
    void testSetInitDateCorrect() throws DateException {
        first_order.setStatus(OrderStatus.CREATED);
        assertTrue(first_order.setInitDate("15/05/2024 12:00:00"));
    }

    @Test
    void testSetInitDateFormatoIncorrecto() {
        first_order.setStatus(OrderStatus.CREATED);
        assertThrows(DateException.class, () -> first_order.setInitDate("2024-05-15 12:00:00"));
    }

    @Test
    void testSetInitDateNull() throws DateException {
        first_order.setStatus(OrderStatus.CREATED);
        assertFalse(first_order.setInitDate(null));
    }

    @Test
    void testSetInitDateVacio() throws DateException {
        first_order.setStatus(OrderStatus.CREATED);
        assertFalse(first_order.setInitDate(""));
    }

    @Test
    void testSetInitDateDiaTresDigitos() {
        first_order.setStatus(OrderStatus.CREATED);
        assertThrows(DateException.class, () -> first_order.setInitDate("123/05/2024 12:00:00"));
    }

    @Test
    void testSetInitDateMesTresDigitos() {
        first_order.setStatus(OrderStatus.CREATED);
        assertThrows(DateException.class, () -> first_order.setInitDate("15/123/2024 12:00:00"));
    }

    @Test
    void testSetInitDateAnioTresDigitos() {
        first_order.setStatus(OrderStatus.CREATED);
        assertThrows(DateException.class, () -> first_order.setInitDate("15/05/123 12:00:00"));
    }

    // ---------- PAYMENT DATE ----------

    @Test
    void testSetPaymentDateCorrect() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertTrue(second_order.setPaymentDate("15/05/2024 12:00:00"));
    }

    @Test
    void testSetPaymentDateFormatoIncorrecto() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setPaymentDate("2024-05-15 12:00:00"));
    }

    @Test
    void testSetPaymentDateNull() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertFalse(second_order.setPaymentDate(null));
    }

    @Test
    void testSetPaymentDateVacio() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertFalse(second_order.setPaymentDate(""));
    }

    @Test
    void testSetPaymentDateDiaTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setPaymentDate("123/05/2024 12:00:00"));
    }

    @Test
    void testSetPaymentDateMesTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setPaymentDate("15/123/2024 12:00:00"));
    }

    @Test
    void testSetPaymentDateAnioTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setPaymentDate("15/05/123 12:00:00"));
    }

    // ---------- DELIVERY DATE ----------

    @Test
    void testSetDeliveryDateCorrect() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertTrue(second_order.setDeliveryDate("15/05/2024 12:00:00"));
    }

    @Test
    void testSetDeliveryDateFormatoIncorrecto() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setDeliveryDate("2024-05-15 12:00:00"));
    }

    @Test
    void testSetDeliveryDateNull() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertFalse(second_order.setDeliveryDate(null));
    }

    @Test
    void testSetDeliveryDateVacio() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertFalse(second_order.setDeliveryDate(""));
    }

    @Test
    void testSetDeliveryDateDiaTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setDeliveryDate("123/05/2024 12:00:00"));
    }

    @Test
    void testSetDeliveryDateMesTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setDeliveryDate("15/123/2024 12:00:00"));
    }

    @Test
    void testSetDeliveryDateAnioTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setDeliveryDate("15/05/123 12:00:00"));
    }

    // ---------- FINISH DATE ----------

    @Test
    void testSetFinishDateCorrect() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertTrue(second_order.setFinishDate("15/05/2024 12:00:00"));
    }

    @Test
    void testSetFinishDateFormatoIncorrecto() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setFinishDate("2024-05-15 12:00:00"));
    }

    @Test
    void testSetFinishDateNull() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertFalse(second_order.setFinishDate(null));
    }

    @Test
    void testSetFinishDateVacio() throws DateException {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertFalse(second_order.setFinishDate(""));
    }

    @Test
    void testSetFinishDateDiaTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setFinishDate("123/05/2024 12:00:00"));
    }

    @Test
    void testSetFinishDateMesTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setFinishDate("15/123/2024 12:00:00"));
    }

    @Test
    void testSetFinishDateAnioTresDigitos() {
        second_order.setStatus(OrderStatus.CONFIRMED);
        assertThrows(DateException.class, () -> second_order.setFinishDate("15/05/123 12:00:00"));
    }

    // ---------- GETTERS PRINCIPALES ----------
    @Test
    void testGetClientId() {
        assertEquals(1, first_order.getClientId());
    }

    @Test
    void testGetReceiveraddress() {
        assertEquals("Calle Correcta", first_order.getReceiveraddress());
    }

    @Test
    void testGetReceiverPerson() {
        assertEquals("Persona Correcta", first_order.getReceiverPerson());
    }

    @Test
    void testGetPhoneContact() {
        assertEquals("666666666", first_order.getPhoneContact());
    }

    // ---------- FALTA LOS PACKAGE DIMENSIONS + EL CARRITO DE LA COMPRA + MÁS HACER
    // SEGUNDO GET INSTANCE ----------

}