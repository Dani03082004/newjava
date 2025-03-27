package com.example.softlearning_springboot.applicationcore.entity.course.dtos;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cursos")
public class CourseSpanishDTO {
    @Id
    @Column(name = "id")
    private int id;
    @JacksonXmlProperty(localName = "nombre_curso")
    private String nameproduct;
    @JacksonXmlProperty(localName = "descripcion_curso")
    private String description;
    @JacksonXmlProperty(localName = "categoria_curso")
    private String category;
    @JacksonXmlProperty(localName = "idioma_curso")
    private String languages;
    @JacksonXmlProperty(localName = "curs")
    private String courses;
    @JacksonXmlProperty(localName = "tutor_curso")
    private String tutor;
    @JacksonXmlProperty(localName = "precio_curso")
    private int price;
    @JacksonXmlProperty(localName = "duration_curso")
    private int duration;

    // Constructor vacío
    public CourseSpanishDTO() {
    }

    // Constructor lleno
    public CourseSpanishDTO(int id, String nameproduct, int price, String description, String category, int duration,
            String languages, String courses,
            String tutor) {
        this.nameproduct = nameproduct;
        this.price = price;
        this.description = description;
        this.category = category;
        this.duration = duration;
        this.languages = languages;
        this.courses = courses;
        this.tutor = tutor;
    }

    // ------------------------ GETTERS --------------------- //
    @JsonGetter("nombre_curso")
    public String getNameproduct() {
        return nameproduct;
    }

    @JsonGetter("descripcion_curso")
    public String getDescription() {
        return description;
    }

    @JsonGetter("categoria_curso")
    public String getCategory() {
        return category;
    }

    @JsonGetter("idioma_curso")
    public String getLanguages() {
        return languages;
    }

    @JsonGetter("curs")
    public String getCourses() {
        return courses;
    }

    @JsonGetter("tutor_curso")
    public String getTutor() {
        return tutor;
    }

    @JsonGetter("precio_curso")
    public int getPrice() {
        return price;
    }

    @JsonGetter("duration_curso")
    public int getDuration() {
        return duration;
    }

    @JsonGetter("id")
    public int getId() {
        return id;
    }

    // ------------------------ SETTERS --------------------- //
    @JsonSetter("nombre_curso")
    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }
    @JsonSetter("descripcion_curso")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonSetter("categoria_curso")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonSetter("idioma_curso")
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @JsonSetter("curs")
    public void setCourses(String courses) {
        this.courses = courses;
    }

    @JsonSetter("tutor_curso")
    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    @JsonSetter("precio_curso")
    public void setPrice(int price) {
        this.price = price;
    }

    @JsonSetter("duration_curso")
    public void setDuration(int duration) {
        this.duration = duration;
    }

    @JsonSetter("id")
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CourseSpanishDTO [id=" + id + ",nameproduct=" + nameproduct + ", description=" + description + ", category="
                + category + ", languages=" + languages + ", courses=" + courses + ", tutor=" + tutor + ", price="
                + price + ", duration=" + duration + "]";
    }
    
}
