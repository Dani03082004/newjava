package com.example.softlearning_springboot.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.softlearning_springboot.applicationcore.entity.course.appservices.CourseServices;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@RestController
@RequestMapping("/softlearning_springboot/courses")
public class RestCourseController {
    @Autowired
    CourseServices courseServices;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonCourseById(@PathVariable(value = "id") Integer id) {
        try {
            return ResponseEntity.ok(courseServices.getByIdToJson(id));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlCourseById(@PathVariable(value = "id") Integer id) {
        try {
            return ResponseEntity.ok(courseServices.getByIdToXml(id));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newCourseFromJson(@RequestBody String coursedata) {
        try {
            return ResponseEntity.ok(courseServices.addFromJson(coursedata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> newCourseFromXml(@RequestBody String coursedata) {
        try {
            return ResponseEntity.ok(courseServices.addFromXml(coursedata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateCourseFromJson(@PathVariable(value = "id") Integer id,
            @RequestBody String coursedata) {
        try {
            return ResponseEntity.ok(courseServices.updateOneFromJson(coursedata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateCourseFromXml(@PathVariable(value = "id") Integer id,
            @RequestBody String coursedata) {
        try {
            return ResponseEntity.ok(courseServices.updateOneFromXml(coursedata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable(value = "id") Integer id) {
        try {
            courseServices.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
