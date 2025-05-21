package com.example.softlearning_springboot.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.softlearning_springboot.applicationcore.entity.book.dtos.BookDTO;
import com.example.softlearning_springboot.applicationcore.entity.book.persistence.BookRepository;


@Repository
public interface JpaBookRepository extends JpaRepository<BookDTO, Integer>,BookRepository {
    public Optional<BookDTO> findByIsbn(String isbn);

    public List<BookDTO> findByNameproduct(String nameproduct);

    @Query(value = "SELECT b FROM BookDTO b WHERE b.nameproduct LIKE %:nameproduct%")
    public List<BookDTO> findByPartialTitle(String nameproduct);

    @Query(value = "SELECT count(*) FROM BookDTO b WHERE b.nameproduct LIKE %:nameproduct%")
    public Integer countByPartialTitle(String nameproduct);

}
