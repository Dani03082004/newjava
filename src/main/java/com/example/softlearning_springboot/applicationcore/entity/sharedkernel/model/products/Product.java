package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.products;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public abstract class Product {
    protected String nameproduct;
    protected int price;
    protected String description;
    protected String category;

    protected Product() {
    }

    // Ya como es abstracta no hace falta getInstance
    public void CheckProductData(String nameproduct, int price, String description, String category) throws BuildException {
        StringBuilder message = new StringBuilder();

        if (!this.setNameproduct(nameproduct)){
            message.append("Bad Name; ");
        }
        if (!this.setPrice(price)){
            message.append("Bad Price; ");
        }
        if (!this.setDescription(description)){
            message.append("Bad Description; ");
        }
        if (!this.setCategory(category)){
            message.append("Bad Category; ");
        }
        
        // Lanzamos una build Exception y asi obtendremos mensajes de error
        if (message.length() > 0) {
            throw new BuildException("Not possible to create the object: " + message.toString());
        }
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public boolean setNameproduct(String nameproduct) {
        if (Checker.NotNullEmptyString(nameproduct) != 0) {
            return false;
        }
        if (!Checker.minLength(nameproduct, 5)) { 
            return false;
        }
        this.nameproduct = nameproduct;
        return true;
    }

    public int getPrice() {
        return price;
    }

    public boolean setPrice(int price) {
        if (Checker.NotNegative(price) != 0) {
            return false; 
        }
        this.price = price;
        return true;
    }
    

    public String getDescription() {
        return description;
    }

    public boolean setDescription(String description) {
        if (Checker.NotNullEmptyString(description) != 0) {
            return false;
        }
        if (!Checker.minLength(description, 10)) { 
            return false;
        }
        this.description = description;
        return true;
    }

    public String getCategory() {
        return category;
    }

    public boolean setCategory(String category) {
        if (Checker.NotNullEmptyString(category) != 0) {
            return false;
        }

        if (!Checker.minLength(category, 5)) { 
            return false;
        }
        this.category = category;
        return true;
    }

    @Override
    public String toString() {
        return "Product [nameproduct=" + nameproduct + ", category=" + category + "]";
    }

    public String getData() {
        StringBuilder mensaje_producto = new StringBuilder();
        mensaje_producto.append("ESTA ES LA INFORMACIÓN DEL PRODUCTO: ");
        mensaje_producto.append(" nombre del Producto: ").append(this.getNameproduct());
        mensaje_producto.append(", precio: ").append(this.getPrice()).append("€");
        mensaje_producto.append(", descripción: ").append(this.getDescription());
        mensaje_producto.append(", categoría: ").append(this.getCategory());
        return mensaje_producto.toString();
    }

    public abstract String getContactData();

    public abstract String getDetails();
}

