
package com.example.softlearning_springboot.applicationcore.entity.course.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

// Falta arreglar el test del constructor de Course, ya que se importa también el Product (y hay que preguntar)

public class CourseTest {

    private Course course;

    @BeforeEach
    public void setUp() throws BuildException {
        course = Course.getInstance("Javasss", 10, "Javasss", "Programming", 10, "Español", "Javasss", "Perico");
    }

    @Test
    void testGetInstanceValid() {
        try {
            Course.getInstance("Javasss", 10, "Javasss", "Programming", 10, "Español", "Javasss", "Perico");
            assertNotNull(course);
        } catch (BuildException e) {
            fail("Error en el GetInstance de Curso: " + e.getMessage());
        }
    }

    @Test
    void testGetInstanceInvalidCourses() {
        try {
            Course.getInstance("Javasss", 10, "Javasss", "Programming", 10, "Español", "Jas", "Perico");
            fail("Expected BuildException due to invalid Courses");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad courses; "));
        }
    }

    @Test
    void testGetInstanceInvalidDuration() {
        try {
            Course.getInstance("Javasss", -10, "Javasss", "Programming", -10, "Español", "Javasss", "Perico");
            fail("Expected BuildException due to invalid Duration");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad duration; "));
        }
    }

    @Test
    void testGetInstanceInvalidLanguages() {
        try {
            Course.getInstance("Javassssss", 10, "Javassssss", "Programming", 10, "ES", "Javassssss", "Perico");
            fail("Expected BuildException due to invalid Languages");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad languages; "));
        }
    }

    @Test
    void testGetInstanceInvalidTutor() {
        try {
            Course.getInstance("Javasss", 10, "Javasss", "Programming", 10, "Español", "Javasss", " ");
            fail("Expected BuildException due to invalid Tutor");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad tutor; "));
        }
    }

    @Test
    void testGetCourses() {
        assertEquals("Javasss", course.getCourses());
    }

    @Test
    void testSetCourses() {
        assertTrue(course.setCourses("Javasss"));    
    }

    @Test
    void testInvalidSetCourses() {
        assertFalse(course.setCourses("Ja"));
        assertFalse(course.setCourses(null));
        assertFalse(course.setCourses(""));  
    }

    @Test
    void testGetDuration() {
        assertEquals(10, course.getDuration());
    }

    @Test
    void testSetDurationValid() {
        assertTrue(course.setDuration(10));
    }

    @Test
    void testSetDurationInvalid() {
        assertFalse(course.setDuration(-10));
    }

    @Test
    void testGetLanguages() {
        assertEquals("Español", course.getLanguages());
    }

    @Test
    void testSetValidLanguages() {
        assertTrue(course.setLanguages("Español"));
    }

    @Test
    void testSetInvalidLanguages() {
        assertFalse(course.setLanguages("Esp"));
        assertFalse(course.setLanguages(null));
        assertFalse(course.setLanguages(""));
    }

    @Test
    void testGetTutor() {
        assertEquals("Perico", course.getTutor());
    }

    @Test
    void testSetTutor() {
        assertTrue(course.setTutor("Perico"));
    }

    @Test
    void testSetInvalidTutor() {
        assertFalse(course.setTutor("Pe"));
        assertFalse(course.setTutor(null));
        assertFalse(course.setTutor(""));
    }

}
