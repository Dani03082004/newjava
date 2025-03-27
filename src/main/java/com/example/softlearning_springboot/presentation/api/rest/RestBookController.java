package com.example.softlearning_springboot.presentation.api.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.softlearning_springboot.applicationcore.entity.book.appservices.BookServices;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@RestController
@RequestMapping("/softlearning_springboot/books")
public class RestBookController {

    @Autowired
    BookServices bookServices;

    @GetMapping(value = "/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonBookByIsbn(@PathVariable(value = "isbn") String isbn) {
        try {
            return ResponseEntity.ok(bookServices.getByIsbnToJson(isbn));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping(value = "/{isbn}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> getXmlBookById(@PathVariable(value = "isbn") String isbn) {
        try {
            return ResponseEntity.ok(bookServices.getByIsbnToXml(isbn));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> newBookFromJson(@RequestBody String bookdata) {
        try {
            return ResponseEntity.ok(bookServices.addFromJson(bookdata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> newBookFromXml(@RequestBody String bookdata) {
        try {
            return ResponseEntity.ok(bookServices.addFromXml(bookdata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{isbn}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateBookFromJson(@PathVariable(value = "isbn") String isbn,
            @RequestBody String bookdata) {
        try {
            return ResponseEntity.ok(bookServices.updateOneFromJson(bookdata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping(value = "/{isbn}", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<String> updateBookFromXml(@PathVariable(value = "isbn") String isbn,
            @RequestBody String bookdata) {
        try {
            return ResponseEntity.ok(bookServices.updateOneFromXml(bookdata));
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteByIsbn(@PathVariable(value = "isbn") String isbn) {
        try {
            bookServices.deleteByIsbn(isbn);
            return ResponseEntity.ok().build();
        } catch (ServiceException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}