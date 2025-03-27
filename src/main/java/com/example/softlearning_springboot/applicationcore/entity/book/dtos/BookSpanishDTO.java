package com.example.softlearning_springboot.applicationcore.entity.book.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Book + Product
@Entity
@Table(name = "libros")
public class BookSpanishDTO {
    @Column(name = "precio")
    private int price;
    @Column(name = "paginas")
    private int pages;
    @Column(name = "nombre")
    private String nameproduct;
    @Column(name = "descripcion")
    private String description;
    @Column(name = "categoria")
    private String category;
    @Column(name = "idioma")
    private String languages;
    @Column(name = "autor")
    private String author;
    @Id
    @Column(name = "isbnesp")
    private String isbn;
    @Column(name = "publicado")
    private String date_publicated; // Fecha
    @Column(name = "disponibilidad")
    private String date_disponibility; // Fecha + Hora
    @Column(name = "alto")
    private double high;
    @Column(name = "ancho")
    private double width;
    @Column(name = "longitud")
    private double length;
    @Column(name = "peso")
    private double weight;
    @Column(name = "fragil")
    private boolean fragile;

    // Constructor vacío
    public BookSpanishDTO() {
    }

    // Constructor lleno
    public BookSpanishDTO(int price, int pages, String nameproduct, String description, String category,
            String languages,
            String author, String isbn, String date_publicated, String date_disponibility, double high,
            double width, double length, double weight, boolean fragile) {
        this.price = price;
        this.pages = pages;
        this.nameproduct = nameproduct;
        this.description = description;
        this.category = category;
        this.languages = languages;
        this.author = author;
        this.isbn = isbn;
        this.date_publicated = date_publicated;
        this.date_disponibility = date_disponibility;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    // ------------------------ GETTERS --------------------- //

    @JsonGetter("precio")
    public int getPrice() {
        return price;
    }

    @JsonGetter("paginas")
    public int getPages() {
        return pages;
    }

    @JsonGetter("nombre")
    public String getNameproduct() {
        return nameproduct;
    }

    @JsonGetter("descripcion")
    public String getDescription() {
        return description;
    }

    @JsonGetter("categoria")
    public String getCategory() {
        return category;
    }

    @JsonGetter("idioma")
    public String getLanguages() {
        return languages;
    }

    @JsonGetter("autor")
    public String getAuthor() {
        return author;
    }

    @JsonGetter("isbnesp")
    public String getIsbn() {
        return isbn;
    }

    @JsonGetter("publicado")
    public String getDate_publicated() {
        return date_publicated;
    }

    @JsonGetter("disponibilidad")
    public String getDate_disponibility() {
        return date_disponibility;
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

    // ------------------------ SETTERS --------------------- //
    @JsonSetter("precio")
    public void setPrice(int price) {
        this.price = price;
    }

    @JsonSetter("paginas")
    public void setPages(int pages) {
        this.pages = pages;
    }

    @JsonSetter("nombre")
    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    @JsonSetter("descripcion")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonSetter("categoria")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonSetter("idioma")
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @JsonSetter("autor")
    public void setAuthor(String author) {
        this.author = author;
    }

    @JsonSetter("isbnesp")
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @JsonSetter("publicado")
    public void setDate_publicated(String date_publicated) {
        this.date_publicated = date_publicated;
    }

    @JsonSetter("disponibilidad")
    public void setDate_disponibility(String date_disponibility) {
        this.date_disponibility = date_disponibility;
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

    @Override
    public String toString() {
        return "BookSpanishDTO [price=" + price + ", pages=" + pages + ", nameproduct=" + nameproduct + ", description="
                + description + ", category=" + category + ", languages=" + languages + ", author=" + author + ", isbn="
                + isbn + ", date_publicated=" + date_publicated + ", date_disponibility=" + date_disponibility
                + ", high=" + high + ", width=" + width + ", length=" + length + ", weight=" + weight + ", fragile="
                + fragile + "]";
    }

}
