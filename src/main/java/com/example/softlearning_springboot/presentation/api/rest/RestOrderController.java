/*package com.example.softlearning_springboot.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.softlearning_springboot.applicationcore.entity.orders.appservices.OrderServices;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@RestController
@RequestMapping("/softlearning_springboot/orders")
public class RestOrderController {

    @Autowired
    OrderServices orderServices;

    @GetMapping(value = "/{clientid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonOrderById(@PathVariable(value = "clientid") int clientid) {
        try {
            return ResponseEntity.ok(orderServices.getByIdToJson(clientid));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping(value = "/{clientid}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlOrderById(@PathVariable(value = "clientid") int clientid) {
        try {
            return ResponseEntity.ok(orderServices.getByIdToXml(clientid));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newOrderFromJson(@RequestBody String order) {
        try {
            return ResponseEntity.ok(orderServices.addFromJson(order));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> newOrderFromXml(@RequestBody String order) {
        try {
            return ResponseEntity.ok(orderServices.addFromXml(order));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{clientid}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateOrderFromJson(@PathVariable(value = "clientid") int clientid,
            @RequestBody String order) {
        try {
            return ResponseEntity.ok(orderServices.updateOneFromJson(order));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{clientid}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateOrderFromXml(@PathVariable(value = "clientid") int clientid,
            @RequestBody String order) {
        try {
            return ResponseEntity.ok(orderServices.updateOneFromXml(order));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @DeleteMapping("/{clientid}")
    public ResponseEntity<String> deleteById(@PathVariable(value = "clientid") int clientid) {
        try {
            orderServices.deleteById(clientid);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}

*/