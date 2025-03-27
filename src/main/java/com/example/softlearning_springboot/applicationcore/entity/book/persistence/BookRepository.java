package com.example.softlearning_springboot.applicationcore.entity.book.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning_springboot.applicationcore.entity.book.dtos.BookDTO;

public interface BookRepository {

    public Optional<BookDTO> findByIsbn(String isbn);

    public List<BookDTO> findByNameproduct(String nameproduct);

    public BookDTO save(BookDTO book);

    public void deleteByIsbn(String isbn);
}

