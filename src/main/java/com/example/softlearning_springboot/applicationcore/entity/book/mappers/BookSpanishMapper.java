package com.example.softlearning_springboot.applicationcore.entity.book.mappers;

import java.time.format.DateTimeFormatter;

import com.example.softlearning_springboot.applicationcore.entity.book.dtos.BookSpanishDTO;
import com.example.softlearning_springboot.applicationcore.entity.book.model.Book;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class BookSpanishMapper {

    public static Book bookFromDTO(BookSpanishDTO bDTO) throws BuildException, DateException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE; 

        return Book.getInstance(
            bDTO.getNameproduct(),
            bDTO.getPrice(),
            bDTO.getDescription(),
            bDTO.getCategory(),
            bDTO.getLanguages(),
            bDTO.getAuthor(),
            bDTO.getIsbn(),
            bDTO.getPages(),
            bDTO.getDate_publicated().formatted(dateFormatter), 
            bDTO.getDate_disponibility().formatted(dateFormatter), 
            bDTO.getHigh(),
            bDTO.getWidth(),
            bDTO.getLength(),
            bDTO.getWeight(),
            bDTO.getFragile()
        );
    }

    public static BookSpanishDTO dtoFromBook(Book book) throws BuildException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE; 
        return new BookSpanishDTO(
            book.getPrice(),
            book.getPages(),
            book.getNameproduct(),
            book.getDescription(),
            book.getCategory(),
            book.getLanguages(),
            book.getAuthor(),
            book.getIsbn(),
            book.getDate_publicated().format(dateFormatter), 
            book.getDate_disponibility().format(dateFormatter), 
            book.getHigh(),
            book.getWidth(),
            book.getLength(),
            book.getWeight(),
            book.getFragile()
        );
    }
}

