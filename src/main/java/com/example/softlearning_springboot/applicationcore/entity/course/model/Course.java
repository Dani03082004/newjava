package com.example.softlearning_springboot.applicationcore.entity.course.model;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.products.Product;

public class Course extends Product {

    protected int duration;
    protected String languages;
    protected String courses;
    protected String tutor;

    protected Course() {
    }

    public static Course getInstance(String nameproduct, int price, String description, String category,
            int duration, String languages, String courses, String tutor) throws BuildException {

        Course co = new Course();
        StringBuilder message = new StringBuilder();

        if (!co.setDuration(duration)) {
            message.append("Bad duration; ");
        }
        if (!co.setLanguages(languages)) {
            message.append("Bad languages; ");
        }
        if (!co.setCourses(courses)) {
            message.append("Bad courses; ");
        }
        if (!co.setTutor(tutor)) {
            message.append("Bad tutor; ");
        }

        try {
            co.CheckProductData(nameproduct, price, description, category);
        } catch (BuildException ex) {
            System.err.println("Failed to create Course: " + ex.getMessage());
        }

        if (message.length() > 0) {
            throw new BuildException("Failed to create Course: " + message.toString());
        }
        return co;
    }

    public int getDuration() {
        return duration;
    }

    public boolean setDuration(int duration) {
        if (Checker.NotNegative(duration) != 0) {
            return false;
        }
        this.duration = duration;
        return true;
    }

    public String getLanguages() {
        return languages;
    }

    public boolean setLanguages(String languages) {
        if (Checker.NotNullEmptyString(languages) != 0) {
            return false; 
        }
        if (Checker.hasSpaces(languages)) {
            return false; 
        }
        this.languages = languages; 
        return true;
    }

    public String getCourses() {
        return courses;
    }

    public boolean setCourses(String courses) {
        if (Checker.NotNullEmptyString(courses) != 0) {
            return false; 
        }
        if (Checker.hasSpaces(courses)) {
            return false; 
        }
        this.courses = courses; 
        return true;
    }
    
    public String getTutor() {
        return tutor;
    }

    public boolean setTutor(String tutor) {
        if (Checker.NotNullEmptyString(tutor) != 0) {
            return false;
        }
        this.tutor = tutor;
        return true;
    }

    @Override
    public String toString() {
        return "Course [courses=" + courses + ", tutor=" + tutor + "]";
    }

    @Override
    public String getContactData() {
        StringBuilder mensaje_curso = new StringBuilder();
        mensaje_curso.append("ESTA ES LA INFORMACIÓN DEL CURSO: ");
        mensaje_curso.append(" duración: ").append(this.getDuration()).append(" horas");
        mensaje_curso.append(", idiomas: ").append(this.getLanguages());
        mensaje_curso.append(", cursos incluidos: ").append(this.getCourses());
        mensaje_curso.append(", tutor: ").append(this.getTutor());
        return mensaje_curso.toString();
    }

    public String getDetails() {
        StringBuilder mensaje_datos_curso = new StringBuilder();
        mensaje_datos_curso.append("INFORMACIÓN DEL CURSO: ");
        mensaje_datos_curso.append(" nombre: ").append(this.getNameproduct());
        mensaje_datos_curso.append(", precio: ").append(this.getPrice()).append("€");
        mensaje_datos_curso.append(", descripción: ").append(this.getDescription());
        mensaje_datos_curso.append(", categoría: ").append(this.getCategory());
        mensaje_datos_curso.append(", duración: ").append(this.getDuration()).append(" horas");
        mensaje_datos_curso.append(", idiomas: ").append(this.getLanguages());
        mensaje_datos_curso.append(", cursos incluidos: ").append(this.getCourses());
        mensaje_datos_curso.append(", tutor: ").append(this.getTutor());
        return mensaje_datos_curso.toString();
    }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

}

