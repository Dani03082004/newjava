package com.example.softlearning_springboot.applicationcore.entity.orders.model;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OrderDetail {
    protected String reference_id;
    protected int amount;
    protected int subtotal_price; 
    protected int discount;
    protected String name_product;

    public OrderDetail() {
    }

    public static OrderDetail getInstance(String reference_id, int amount, int subtotal_price, int discount, String name_product) throws BuildException {
        OrderDetail orderDetail = new OrderDetail();
        StringBuilder message = new StringBuilder();

        if (!orderDetail.setReference_id(reference_id)) {
            message.append("Bad reference_id; ");
        }
        if (!orderDetail.setAmount(amount)) {
            message.append("Bad amount; ");
        }
        if (!orderDetail.setSubtotal_price(subtotal_price)) {
            message.append("Bad subtotal_price; ");
        }
        if (!orderDetail.setDiscount(discount)) {
            message.append("Bad discount; ");
        }
        if (!orderDetail.setName_product(name_product)) {
            message.append("Bad name_product; ");
        }

        // Si hay errores, lanzamos la excepción BuildException
        if (message.length() > 0) {
            throw new BuildException("Failed to create OrderDetail: " + message.toString());
        }
        
        return orderDetail;
    }

    public String getReference_id() {
        return reference_id;
    }

    public boolean setReference_id(String reference_id) {
        if (Checker.NotNullEmptyString(reference_id) != 0) {
            return false;
        }
        this.reference_id = reference_id;
        return true;
    }

    public int getAmount() {
        return amount;
    }

    public boolean setAmount(int amount) {
        if (Checker.NotNegative(amount) != 0) {
            return false;
        }
        this.amount = amount;
        return true;
    }

    public int getSubtotal_price() {
        return subtotal_price;
    }

    public boolean setSubtotal_price(int subtotal_price) {
        if (Checker.NotNegative(subtotal_price) != 0) {
            return false;
        }
        this.subtotal_price = subtotal_price;
        return true;
    }

    public int getDiscount() {
        return discount;
    }

    public boolean setDiscount(int discount) {
        if (Checker.NotNegative(discount) != 0) {
            return false;
        }
        this.discount = discount;
        return true;
    }

    public String getName_product() {
        return name_product;
    }

    public boolean setName_product(String name_product) {
        if (Checker.NotNullEmptyString(name_product) != 0) {
            return false;
        }
        this.name_product = name_product;
        return true;
    }


    @Override
    public String toString() {
        return "OrderDetail [reference_id=" + reference_id + ", amount=" + amount + ", subtotal_price=" + subtotal_price
                + ", discount=" + discount + ", name_product=" + name_product + "]";
    }

    public String getContactData() {
        StringBuilder printData = new StringBuilder("ESTE ES EL ORDER DETAIL: ");
        printData.append("El id de referencia es: ").append(this.getReference_id());
        printData.append(", el nombre del producto es: ").append(this.getName_product());
        printData.append(", la cantidad es: ").append(this.getAmount());
        printData.append(", el precio subtotal es: ").append(this.getSubtotal_price());
        printData.append(", el descuento es: ").append(this.getDiscount()).append("%");
        return printData.toString();
    }
    
}
