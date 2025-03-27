package com.example.softlearning_springboot.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.softlearning_springboot.applicationcore.entity.employee.appservices.EmployeeServices;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@RestController
@RequestMapping("/softlearning_springboot/employees")

public class RestEmployeeController {
@Autowired
    EmployeeServices employeeServices;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonEmployeeById(@PathVariable(value = "id") Integer id) {
        try {
            return ResponseEntity.ok(employeeServices.getByIdToJson(id));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlEmployeeById(@PathVariable(value = "id") Integer id) {
        try {
            return ResponseEntity.ok(employeeServices.getByIdToXml(id));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newEmployeeFromJson(@RequestBody String Employeedata) {
        try {
            return ResponseEntity.ok(employeeServices.addFromJson(Employeedata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> newEmployeeFromXml(@RequestBody String Employeedata) {
        try {
            return ResponseEntity.ok(employeeServices.addFromXml(Employeedata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateEmployeeFromJson(@PathVariable(value = "id") Integer id,
            @RequestBody String Employeedata) {
        try {
            return ResponseEntity.ok(employeeServices.updateOneFromJson(Employeedata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateEmployeeFromXml(@PathVariable(value = "id") Integer id,
            @RequestBody String Employeedata) {
        try {
            return ResponseEntity.ok(employeeServices.updateOneFromXml(Employeedata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByID(@PathVariable(value = "id") Integer id) {
        try {
            employeeServices.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
