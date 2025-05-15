package com.example.softlearning_springboot.applicationcore.entity.orders.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OrderDetailTest {

    private OrderDetail orderDetail;

    @BeforeEach
    void setUp() {
        orderDetail = new OrderDetail();
        orderDetail.setReference_id("REF123");
        orderDetail.setAmount(10);
        orderDetail.setSubtotal_price(100);
        orderDetail.setDiscount(5);
        orderDetail.setName_product("Producto Test");
    }

    // ---------- TESTS DE CONSTRUCCIÓN ----------
    @Test
    void testGetInstanceCorrect() {
        assertDoesNotThrow(() -> {
            OrderDetail.getInstance("REF123", 10, 100, 5, "Producto Test");
        });
    }

    @Test
    void testGetInstanceDatosIncorrectos() {
        Exception ex = assertThrows(BuildException.class, () -> {
            OrderDetail.getInstance("", -1, -1, -1, "");
        });
        assertTrue(ex.getMessage().contains("Bad"));
    }

    // ---------- REFERENCE_ID ----------
    @Test
    void testSetReferenceIdCorrect() {
        assertTrue(orderDetail.setReference_id("REF123"));
    }

    @Test
    void testSetReferenceIdNull() {
        assertFalse(orderDetail.setReference_id(null));
    }

    @Test
    void testSetReferenceIdVacio() {
        assertFalse(orderDetail.setReference_id(""));
    }

    @Test
    void testSetReferenceIdCero() {
        assertTrue(orderDetail.setReference_id("0"));
    }

    // ---------- AMOUNT ----------
    @Test
    void testSetAmountCorrect() {
        assertTrue(orderDetail.setAmount(10));
    }

    @Test
    void testSetAmountIncorrect() {
        assertFalse(orderDetail.setAmount(-1));
    }

    @Test
    void testSetAmountCero() {
        assertTrue(orderDetail.setAmount(0));
    }

    @Test
    void testSetAmountMaximo() {
        assertTrue(orderDetail.setAmount(Integer.MAX_VALUE));
    }

    // ---------- SUBTOTAL_PRICE ----------
    @Test
    void testSetSubtotalPriceCorrect() {
        assertTrue(orderDetail.setSubtotal_price(100));
    }

    @Test
    void testSetSubtotalPriceIncorrect() {
        assertFalse(orderDetail.setSubtotal_price(-1));
    }

    @Test
    void testSetSubtotalPriceCero() {
        assertTrue(orderDetail.setSubtotal_price(0));
    }

    @Test
    void testSetSubtotalPriceMaximo() {
        assertTrue(orderDetail.setSubtotal_price(Integer.MAX_VALUE));
    }

    // ---------- DISCOUNT ----------
    @Test
    void testSetDiscountCorrect() {
        assertTrue(orderDetail.setDiscount(5));
    }

    @Test
    void testSetDiscountIncorrect() {
        assertFalse(orderDetail.setDiscount(-1));
    }

    @Test
    void testSetDiscountCero() {
        assertTrue(orderDetail.setDiscount(0));
    }

    @Test
    void testSetDiscountMaximo() {
        assertTrue(orderDetail.setDiscount(Integer.MAX_VALUE));
    }

    // ---------- NAME_PRODUCT ----------
    @Test
    void testSetNameProductCorrect() {
        assertTrue(orderDetail.setName_product("Producto Test"));
    }

    @Test
    void testSetNameProductIncorrect() {
        assertFalse(orderDetail.setName_product(""));
    }

    @Test
    void testSetNameProductNull() {
        assertFalse(orderDetail.setName_product(null));
    }

    @Test
    void testSetNameProductCero() {
        assertTrue(orderDetail.setName_product("0"));
    }

    // ---------- GETTERS ----------
    @Test
    void testGetReferenceId() {
        assertEquals("REF123", orderDetail.getReference_id());
    }

    @Test
    void testGetAmount() {
        assertEquals(10, orderDetail.getAmount());
    }

    @Test
    void testGetSubtotalPrice() {
        assertEquals(100, orderDetail.getSubtotal_price());
    }

    @Test
    void testGetDiscount() {
        assertEquals(5, orderDetail.getDiscount());
    }

    @Test
    void testGetNameProduct() {
        assertEquals("Producto Test", orderDetail.getName_product());
    }
}