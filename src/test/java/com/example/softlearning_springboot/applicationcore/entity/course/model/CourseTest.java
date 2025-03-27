package com.example.softlearning_springboot.applicationcore.entity.course.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

// Falta arreglar el test del constructor de Course, ya que se importa también el Product (y hay que preguntar)

public class CourseTest {

    @Test
    void testGetCourses() {
        Course course = new Course();
        course.setCourses("Java");
        assertEquals("Java", course.getCourses());
    }

    @Test
    void testGetDuration() {
        Course course = new Course();
        course.setDuration(10);
        assertEquals(10, course.getDuration());
    }

    @Test
    void testGetInstance() {
        try {
            Course course = Course.getInstance("Java", 10, "Java", "Programming", 10, "Español", "Java", "Perico");
            assertEquals("Java", course.getCourses());
            assertEquals(10, course.getDuration());
            assertEquals("Español", course.getLanguages());
            assertEquals("Perico", course.getTutor());
        } catch (BuildException e) {
            fail("Error en el GetInstance de Curso");
        }
    }

    @Test
    void testGetLanguages() {
        Course course = new Course();
        course.setLanguages("Español");
        assertEquals("Español", course.getLanguages());
    }

    @Test
    void testGetTutor() {
        Course course = new Course();
        course.setTutor("Perico");
        assertEquals("Perico", course.getTutor());
    }

    @Test
    void testSetCourses() {
        Course course = new Course();
        assertTrue(course.setCourses("Java"));    
    }

    @Test
    void testSetDuration() {
        Course course = new Course();
        assertTrue(course.setDuration(10));
    }

    @Test
    void testSetLanguages() {
        Course course = new Course();
        assertTrue(course.setLanguages("Español"));
    }

    @Test
    void testSetTutor() {
        Course course = new Course();
        assertTrue(course.setTutor("Perico"));
    }

}
