package com.example.softlearning_springboot.applicationcore.entity.orders.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Orden")
public class OrderSpanishDTO {
    @JacksonXmlProperty(localName = "id_cliente")
    private int clientid;
    @JacksonXmlProperty(localName = "referencia")
    private int reference;
    @JacksonXmlProperty(localName = "alto")
    private double high;
    @JacksonXmlProperty(localName = "ancho")
    private double width;
    @JacksonXmlProperty(localName = "longitud")
    private double length;
    @JacksonXmlProperty(localName = "peso")
    private double weight;
    @JacksonXmlProperty(localName = "fragil")
    private boolean fragile;
    @JacksonXmlProperty(localName = "direccion_receptor")
    private String receiveraddress;
    @JacksonXmlProperty(localName = "persona_receptor")
    private String receiverPerson;
    @JacksonXmlProperty(localName = "descripcion")
    private String description;
    @JacksonXmlProperty(localName = "contacto_telefono")
    private String phoneContact;
    @JacksonXmlProperty(localName = "fecha_inicio")
    private String initdate;
    @JacksonXmlProperty(localName = "fecha_fin")
    private String finishdate;
    @JacksonXmlProperty(localName = "fecha_pago")
    private String paymentDate;
    @JacksonXmlProperty(localName = "fecha_entrega")
    private String deliveryDate;
    @JacksonXmlProperty(localName = "carrito_compras")
    private String shoppingcart;

    // Constructor vacio
    public OrderSpanishDTO() {
    }

    // Constructor lleno
    public OrderSpanishDTO(int clientid, int reference, double high, double width, double length, double weight,
            boolean fragile, String receiveraddress, String receiverPerson, String description,
            String shoppingcart, String phoneContact, String initdate, String finishdate, String paymentDate, String deliveryDate) {
        this.clientid = clientid;
        this.reference = reference;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
        this.receiveraddress = receiveraddress;
        this.receiverPerson = receiverPerson;
        this.description = description;
        this.shoppingcart = shoppingcart;
        this.phoneContact = phoneContact;
        this.initdate = initdate;
        this.finishdate = finishdate;
        this.paymentDate = paymentDate;
        this.deliveryDate = deliveryDate;
    }

    // ------------------------ GETTERS --------------------- //
    @JsonGetter("id_cliente")
    public int getClientid() {
        return clientid;
    }

    @JsonGetter("referencia")
    public int getReference() {
        return reference;
    }

    @JsonGetter("alto")
    public double getHigh() {
        return high;
    }

    @JsonGetter("ancho")
    public double getWidth() {
        return width;
    }

    @JsonGetter("longitud")
    public double getLength() {
        return length;
    }

    @JsonGetter("peso")
    public double getWeight() {
        return weight;
    }

    @JsonGetter("fragil")
    public boolean getFragile() {
        return fragile;
    }

    @JsonGetter("direccion_receptor")
    public String getReceiveraddress() {
        return receiveraddress;
    }

    @JsonGetter("persona_receptor")
    public String getReceiverPerson() {
        return receiverPerson;
    }

    @JsonGetter("descripcion")
    public String getDescription() {
        return description;
    }

    @JsonGetter("contacto_telefono")
    public String getPhoneContact() {
        return phoneContact;
    }

    @JsonGetter("fecha_inicio")
    public String getInitdate() {
        return initdate;
    }

    @JsonGetter("fecha_fin")
    public String getFinishdate() {
        return finishdate;
    }

    @JsonGetter("fecha_pago")
    public String getPaymentDate() {
        return paymentDate;
    }

    @JsonGetter("fecha_entrega")
    public String getDeliveryDate() {
        return deliveryDate;
    }

    @JsonGetter("carrito_compras")
    public String getShoppingcart() {
        return shoppingcart;
    }

    // ------------------------ SETTERS --------------------- //
    @JsonSetter("id_cliente")
    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    @JsonSetter("referencia")
    public void setReference(int reference) {
        this.reference = reference;
    }

    @JsonSetter("alto")
    public void setHigh(double high) {
        this.high = high;
    }

    @JsonSetter("ancho")
    public void setWidth(double width) {
        this.width = width;
    }

    @JsonSetter("longitud")
    public void setLength(double length) {
        this.length = length;
    }

    @JsonSetter("peso")
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @JsonSetter("fragil")
    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    @JsonSetter("direccion_receptor")
    public void setReceiveraddress(String receiveraddress) {
        this.receiveraddress = receiveraddress;
    }

    @JsonSetter("persona_receptor")
    public void setReceiverPerson(String receiverPerson) {
        this.receiverPerson = receiverPerson;
    }

    @JsonSetter("descripcion")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonSetter("contacto_telefono")
    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    @JsonSetter("fecha_inicio")
    public void setInitdate(String initdate) {
        this.initdate = initdate;
    }

    @JsonSetter("fecha_fin")
    public void setFinishdate(String finishdate) {
        this.finishdate = finishdate;
    }

    @JsonSetter("fecha_pago")
    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    @JsonSetter("fecha_entrega")
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @JsonSetter("carrito_compras")
    public void setShoppingcart(String shoppingcart) {
        this.shoppingcart = shoppingcart;
    }

    @Override
    public String toString() {
        return "OrderSpanishDTO [clientid=" + clientid + ", reference=" + reference + ", high=" + high + ", width=" + width +
                ", length=" + length + ", weight=" + weight + ", fragile=" + fragile + ", receiveraddress=" + receiveraddress +
                ", receiverPerson=" + receiverPerson + ", description=" + description + ", phoneContact=" + phoneContact +
                ", initdate=" + initdate + ", finishdate=" + finishdate + ", paymentDate=" + paymentDate + ", deliveryDate=" +
                deliveryDate + ", shoppingcart=" + shoppingcart + "]";
    }
}
