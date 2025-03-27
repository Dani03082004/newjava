package com.example.softlearning_springboot.applicationcore.entity.orders.dtos;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderDetailDTO;

// Order + OrderDetail
@Entity
@Table(name = "orders")
public class OrderDTO {
    @Id
    @Column(name = "clientid")
    private int clientid;
    
    @Column(name = "reference")
    private int reference;
    
    @Column(name = "high")
    private double high;
    
    @Column(name = "width")
    private double width;
    
    @Column(name = "length")
    private double length;
    
    @Column(name = "weight")
    private double weight;
    
    @Column(name = "fragile")
    private boolean fragile;
    
    @Column(name = "receiver_address")
    private String receiver_address;
    
    @Column(name = "receiver_person")
    private String receiver_person;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "phone_contact")
    private String phone_contact;
    
    @Column(name = "initdate")
    private String initdate;
    
    @Column(name = "finishdate")
    private String finishdate;
    
    @Column(name = "paymentdate")
    private String paymentdate;
    
    @Column(name = "deliverydate")
    private String deliverydate;

    // Relación OneToMany con OrderDetailDTO
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderDetailDTO> shoppingcart;

    public OrderDTO() {
    }

    public OrderDTO(int clientid, int reference, double high, double width, double length, double weight,
                    boolean fragile, String receiver_address, String receiver_person, String description,
                    ArrayList<OrderDetailDTO> shoppingcart, String phone_contact, String initdate, String finishdate, 
                    String paymentdate, String deliverydate) {
        this.clientid = clientid;
        this.reference = reference;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
        this.receiver_address = receiver_address;
        this.receiver_person = receiver_person;
        this.description = description;
        this.shoppingcart = shoppingcart;
        this.phone_contact = phone_contact;
        this.initdate = initdate;
        this.finishdate = finishdate;
        this.paymentdate = paymentdate;
        this.deliverydate = deliverydate;
    }

    public int getClientid() {
        return clientid;
    }

    public int getReference() {
        return reference;
    }

    public double getHigh() {
        return high;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getWeight() {
        return weight;
    }

    public boolean getFragile() {
        return fragile;
    }

    public String getReceiver_address() {
        return receiver_address;
    }

    public String getReceiver_person() {
        return receiver_person;
    }

    public String getDescription() {
        return description;
    }

    public String getPhone_contact() {
        return phone_contact;
    }

    public String getInitdate() {
        return initdate;
    }

    public String getFinishdate() {
        return finishdate;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public List<OrderDetailDTO> getShoppingcart() {
        return shoppingcart;
    }

    @Override
    public String toString() {
        return "OrderDTO [clientid=" + clientid + ", reference=" + reference + ", high=" + high + ", width=" + width +
               ", length=" + length + ", weight=" + weight + ", fragile=" + fragile + ", receiver_address=" + receiver_address +
               ", receiver_person=" + receiver_person + ", description=" + description + ", phone_contact=" + phone_contact +
               ", initdate=" + initdate + ", finishdate=" + finishdate + ", paymentdate=" + paymentdate + ", deliverydate=" +
               deliverydate + ", shoppingcart=" + shoppingcart + "]";
    }
}
