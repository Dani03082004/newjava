package com.example.softlearning_springboot.applicationcore.entity.course.dtos;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name = "courses")
public class CourseDTO {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nameproduct")
    private String nameproduct;
    @Column(name = "description")
    private String description;
    @Column(name = "category")
    private String category; 
    @Column(name = "languages")
    private String languages;
    @Column(name = "courses")
    private String courses; 
    @Column(name = "tutor")
    private String tutor;
    @Column(name = "price")
    private int price;
    @Column(name = "duration")
    private int duration;
    
    // Constructor vacío
    public CourseDTO() {
    }

    // Constructor lleno
    public CourseDTO(int id, String nameproduct, int price, String description, String category, int duration, String languages, String courses,
            String tutor) {
        this.id = id;
        this.nameproduct = nameproduct;
        this.price = price;
        this.description = description;
        this.category = category;
        this.duration = duration;
        this.languages = languages;
        this.courses = courses;
        this.tutor = tutor;
    }

    public int getId() {
        return id;
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

    public String getCourses() {
        return courses;
    }

    public String getTutor() {
        return tutor;
    }

    public int getPrice() {
        return price;
    }
    
    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "CourseDTO [id=" + id + ",nameproduct=" + nameproduct + ", description=" + description + ", category=" + category
                + ", languages=" + languages + ", courses=" + courses + ", tutor=" + tutor + ", price=" + price
                + ", duration=" + duration + "]";
    }

}
