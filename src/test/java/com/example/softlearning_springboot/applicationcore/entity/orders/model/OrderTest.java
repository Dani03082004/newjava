package com.example.softlearning_springboot.applicationcore.entity.orders.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OrderTest {

    private Order order;

    @BeforeEach
    void setUp() throws Exception {
        order = Order.getInstance(
        1, "Calle Correcta", "Persona Correcta", "666666666",
        123, "Valid description for order", "15/05/2024 12:00:00"
    );
    }

    // ---------- TESTS DE CONSTRUCCIÓN ----------
    @Test
    void testGetInstanceCorrect() {
        assertDoesNotThrow(() -> {
            Order.getInstance(
                1, "Calle Correcta", "Persona Correcta", "666666666",
                123, "Descripción válida", "15/05/2024 12:00:00"
            );
        });
    }

    // ---------- CLIENT ID ----------
    @Test
    void testSetClientIdCorrect() {
        assertTrue(order.setClientId(10));
    }

    @Test
    void testSetClientIdIncorrect() {
        assertFalse(order.setClientId(-1));
    }

    @Test
    void testSetClientIdCero() {
        assertFalse(order.setClientId(0));
    }

    // ---------- RECEIVER ADDRESS ----------
    @Test
    void testSetReceiverAddressCorrect() {
        assertTrue(order.setReceiveraddress("Calle Correcta"));
    }

    @Test
    void testSetReceiverAddressIncorrect() {
        assertFalse(order.setReceiveraddress("abc"));
    }

    @Test
    void testSetReceiverAddressNull() {
        assertFalse(order.setReceiveraddress(null));
    }

    @Test
    void testSetReceiverAddressVacio() {
        assertFalse(order.setReceiveraddress(""));
    }

    // ---------- RECEIVER PERSON ----------
    @Test
    void testSetReceiverPersonCorrect() {
        assertTrue(order.setReceiverPerson("Persona Correcta"));
    }

    @Test
    void testSetReceiverPersonIncorrect() {
        assertFalse(order.setReceiverPerson("abc"));
    }

    @Test
    void testSetReceiverPersonNull() {
        assertFalse(order.setReceiverPerson(null));
    }

    @Test
    void testSetReceiverPersonVacio() {
        assertFalse(order.setReceiverPerson(""));
    }

    // ---------- PHONE CONTACT ----------
    @Test
    void testSetPhoneContactCorrect() {
        assertTrue(order.setPhoneContact("666666666"));
    }

    @Test
    void testSetPhoneContactIncorrect() {
        assertFalse(order.setPhoneContact("123")); 
    }

    @Test
    void testSetPhoneContactNull() {
        assertFalse(order.setPhoneContact(null));
    }

    @Test
    void testSetPhoneContactVacio() {
        assertFalse(order.setPhoneContact(""));
    }

    @Test
    void testSetPhoneContactMultipleCorrect() {
        assertTrue(order.setPhoneContact("666666666,777777777"));
    }

    @Test
    void testSetPhoneContactMultipleUnoIncorrecto() {
        assertFalse(order.setPhoneContact("666666666,123"));
    }

    // ---------- FECHAS (initdate, paymentDate, deliveryDate, finishdate) ----------
    @Test
    void testSetInitDateCorrect() throws DateException {
        assertTrue(order.setInitDate("15/05/2024 12:00:00"));
    }

    @Test
    void testSetInitDateFormatoIncorrecto() throws DateException {
        assertFalse(order.setInitDate("2024-05-15 12:00:00"));
    }

    @Test
    void testSetInitDateNull() throws DateException {
        assertFalse(order.setInitDate(null));
    }

    @Test
    void testSetInitDateVacio() throws DateException {
        assertFalse(order.setInitDate(""));
    }

    @Test
    void testSetInitDateDiaTresDigitos() throws DateException {
        assertFalse(order.setInitDate("123/05/2024 12:00:00"));
    }

    @Test
    void testSetInitDateMesTresDigitos() throws DateException {
        assertFalse(order.setInitDate("15/123/2024 12:00:00"));
    }

    @Test
    void testSetInitDateAnioTresDigitos() throws DateException {
        assertFalse(order.setInitDate("15/05/123 12:00:00"));
    }

    @Test
    void testSetPaymentDateCorrect() throws DateException {
        assertTrue(order.setPaymentDate("15/05/2024 12:00:00"));
    }

    @Test
    void testSetPaymentDateFormatoIncorrecto() throws DateException {
        assertFalse(order.setPaymentDate("2024-05-15 12:00:00"));
    }

    @Test
    void testSetPaymentDateNull() throws DateException {
        assertFalse(order.setPaymentDate(null));
    }

    @Test
    void testSetPaymentDateVacio() throws DateException {
        assertFalse(order.setPaymentDate(""));
    }

    @Test
    void testSetPaymentDateDiaTresDigitos() throws DateException {
        assertFalse(order.setPaymentDate("123/05/2024 12:00:00"));
    }

    @Test
    void testSetPaymentDateMesTresDigitos() throws DateException {
        assertFalse(order.setPaymentDate("15/123/2024 12:00:00"));
    }

    @Test
    void testSetPaymentDateAnioTresDigitos() throws DateException {
        assertFalse(order.setPaymentDate("15/05/123 12:00:00"));
    }

    @Test
    void testSetDeliveryDateCorrect() throws DateException {
        assertTrue(order.setDeliveryDate("15/05/2024 12:00:00"));
    }

    @Test
    void testSetDeliveryDateFormatoIncorrecto() throws DateException {
        assertFalse(order.setDeliveryDate("2024-05-15 12:00:00"));
    }

    @Test
    void testSetDeliveryDateNull() throws DateException {
        assertFalse(order.setDeliveryDate(null));
    }

    @Test
    void testSetDeliveryDateVacio() throws DateException {
        assertFalse(order.setDeliveryDate(""));
    }

    @Test
    void testSetDeliveryDateDiaTresDigitos() throws DateException {
        assertFalse(order.setDeliveryDate("123/05/2024 12:00:00"));
    }

    @Test
    void testSetDeliveryDateMesTresDigitos() throws DateException {
        assertFalse(order.setDeliveryDate("15/123/2024 12:00:00"));
    }

    @Test
    void testSetDeliveryDateAnioTresDigitos() throws DateException {
        assertFalse(order.setDeliveryDate("15/05/123 12:00:00"));
    }

    @Test
    void testSetFinishDateCorrect() throws DateException {
        assertTrue(order.setFinishDate("15/05/2024 12:00:00"));
    }

    @Test
    void testSetFinishDateFormatoIncorrecto() throws DateException {
        assertFalse(order.setFinishDate("2024-05-15 12:00:00"));
    }

    @Test
    void testSetFinishDateNull() throws DateException {
        assertFalse(order.setFinishDate(null));
    }

    @Test
    void testSetFinishDateVacio() throws DateException {
        assertFalse(order.setFinishDate(""));
    }

    @Test
    void testSetFinishDateDiaTresDigitos() throws DateException {
        assertFalse(order.setFinishDate("123/05/2024 12:00:00"));
    }

    @Test
    void testSetFinishDateMesTresDigitos() throws DateException {
        assertFalse(order.setFinishDate("15/123/2024 12:00:00"));
    }

    @Test
    void testSetFinishDateAnioTresDigitos() throws DateException {
        assertFalse(order.setFinishDate("15/05/123 12:00:00"));
    }

    // ---------- GETTERS PRINCIPALES ----------
    @Test
    void testGetClientId() {
        assertEquals(1, order.getClientId());
    }

    @Test
    void testGetReceiveraddress() {
        assertEquals("Calle Correcta", order.getReceiveraddress());
    }

    @Test
    void testGetReceiverPerson() {
        assertEquals("Persona Correcta", order.getReceiverPerson());
    }

    @Test
    void testGetPhoneContact() {
        assertEquals("666666666", order.getPhoneContact());
    }

    // ---------- FALTA LOS PACKAGE DIMENSIONS + EL CARRITO DE LA COMPRA + MÁS HACER SEGUNDO GET INSTANCE ----------



}