package com.example.softlearning_springboot.applicationcore.entity.book.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

// Book + Product
@Entity
@Table(name = "books")
public class BookDTO {

    @Id
    @Column(name = "isbn")
    private String isbn; 

    @Column(name = "price")
    private int price;

    @Column(name = "pages")
    private int pages;

    @Column(name = "nameproduct")
    private String nameproduct;

    @Column(name = "description")
    private String description;

    @Column(name = "category")
    private String category;

    @Column(name = "languages")
    private String languages;

    @Column(name = "author")
    private String author;

    @Column(name = "date_publicated")
    private String date_publicated;

    @Column(name = "date_disponibility")
    private String date_disponibility;

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

    // Constructor vacío
    public BookDTO() {
    }

    // Constructor completo
    public BookDTO(String isbn, int price, int pages, String nameproduct, String description, String category,
                   String languages, String author, String date_publicated, String date_disponibility, double high,
                   double width, double length, double weight, boolean fragile) {
        this.isbn = isbn;
        this.price = price;
        this.pages = pages;
        this.nameproduct = nameproduct;
        this.description = description;
        this.category = category;
        this.languages = languages;
        this.author = author;
        this.date_publicated = date_publicated;
        this.date_disponibility = date_disponibility;
        this.high = high;
        this.width = width;
        this.length = length;
        this.weight = weight;
        this.fragile = fragile;
    }

    // Getters

    public String getIsbn() {
        return isbn;
    }

    public int getPrice() {
        return price;
    }

    public int getPages() {
        return pages;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguages() {
        return languages;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate_publicated() {
        return date_publicated;
    }

    public String getDate_disponibility() {
        return date_disponibility;
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

    @Override
    public String toString() {
        return "BookDTO [price=" + price + ", pages=" + pages + ", nameproduct=" + nameproduct + ", description="
                + description + ", category=" + category + ", languages=" + languages + ", author=" + author + ", isbn="
                + isbn + ", date_publicated=" + date_publicated + ", date_disponibility=" + date_disponibility
                + ", high=" + high + ", width=" + width + ", length=" + length + ", weight=" + weight + ", fragile="
                + fragile + "]";
    }

}
