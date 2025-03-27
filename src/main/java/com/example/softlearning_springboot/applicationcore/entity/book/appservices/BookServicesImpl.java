package com.example.softlearning_springboot.applicationcore.entity.book.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning_springboot.applicationcore.entity.book.dtos.BookDTO;
import com.example.softlearning_springboot.applicationcore.entity.book.mappers.BookMapper;
import com.example.softlearning_springboot.applicationcore.entity.book.persistence.BookRepository;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class BookServicesImpl implements BookServices {

    @Autowired
    private BookRepository BookRepository;
    private Serializer<BookDTO> serializer;

    protected BookDTO getDTO(String isbn) {
        return BookRepository.findByIsbn(isbn).orElse(null);
    }

    protected BookDTO getByIsbn(String isbn) throws ServiceException {
        BookDTO bdto = this.getDTO(isbn);

        if (bdto == null) {
            throw new ServiceException("Book with ISBN " + isbn + " not found");
        }
        return bdto;
    }

    protected BookDTO checkInputData(String book) throws ServiceException {
        try {
            BookDTO bdto = this.serializer.deserialize(book, BookDTO.class);
            BookMapper.bookFromDTO(bdto);
            return bdto;
        } catch (Exception e) {
            throw new ServiceException("Error in the input book data: " + e.getMessage());
        }
    }

    protected BookDTO newBook(String book) throws ServiceException {
        BookDTO bdto = this.checkInputData(book);

        if (this.getDTO(bdto.getIsbn()) == null) {
            return BookRepository.save(bdto);
        }
        throw new ServiceException("Book with ISBN " + bdto.getIsbn() + " already exists");
    }

    protected BookDTO updateBook(String book) throws ServiceException {
        try {
            BookDTO bdto = this.checkInputData(book);
            this.getByIsbn(bdto.getIsbn());
            return BookRepository.save(bdto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @Override
    public String getByIsbnToJson(String isbn) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.JSON_BOOK).serialize(this.getByIsbn(isbn));
        } catch (Exception e) {
            throw new ServiceException("Error getting book as JSON: " + e.getMessage());
        }
    }
    
    @Override
    public String getByIsbnToXml(String isbn) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.XML_BOOK).serialize(this.getByIsbn(isbn));
        } catch (Exception e) {
            throw new ServiceException("Error getting book as XML: " + e.getMessage());
        }
    }
    
    @Override
    public String addFromJson(String book) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_BOOK);
            return serializer.serialize(this.newBook(book));
        } catch (Exception e) {
            throw new ServiceException("Error adding book from JSON: " + e.getMessage());
        }
    }
    
    @Override
    public String addFromXml(String book) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_BOOK);
            return serializer.serialize(this.newBook(book));
        } catch (Exception e) {
            throw new ServiceException("Error adding book from XML: " + e.getMessage());
        }
    }
    
    @Override
    public String updateOneFromJson(String book) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_BOOK);
            return serializer.serialize(this.updateBook(book));
        } catch (Exception e) {
            throw new ServiceException("Error updating book from JSON: " + e.getMessage());
        }
    }
    
    @Override
    public String updateOneFromXml(String book) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_BOOK);
            return serializer.serialize(this.updateBook(book));
        } catch (Exception e) {
            throw new ServiceException("Error updating book from XML: " + e.getMessage());
        }
    }
    

    @Override
    public void deleteByIsbn(String isbn) throws ServiceException {
        try {
            this.getByIsbn(isbn);
            BookRepository.deleteByIsbn(isbn);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
