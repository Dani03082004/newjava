package com.example.softlearning_springboot.applicationcore.entity.orders.dtos;

import jakarta.persistence.*;
import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderDTO;


@Entity
@Table(name = "order_details")
public class OrderDetailDTO {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private int amount;

    @Column(name = "subtotal_price")
    private double subtotal_price;

    @Column(name = "discount")
    private double discount;

    @Column(name = "name_product")
    private String name_product;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderDTO order;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int amount, double subtotal_price, double discount, String name_product, OrderDTO order) {
        this.amount = amount;
        this.subtotal_price = subtotal_price;
        this.discount = discount;
        this.name_product = name_product;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public double getSubtotal_price() {
        return subtotal_price;
    }

    public double getDiscount() {
        return discount;
    }

    public String getName_product() {
        return name_product;
    }

    public OrderDTO getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "OrderDetailDTO [id=" + id + ", amount=" + amount + 
               ", subtotal_price=" + subtotal_price + ", discount=" + discount + 
               ", name_product=" + name_product + ", orderId=" + (order != null ? order.getReference() : "null") + "]";
    }
}
