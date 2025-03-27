package com.example.softlearning_springboot.functionals;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.example.softlearning_springboot.applicationcore.entity.book.dtos.BookDTO;
import com.example.softlearning_springboot.infrastructure.persistence.jpa.JpaBookRepository;

// Se ejecuta TODO desde aqui

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SoftlearningBookApplication {
    @Test
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SoftlearningBookApplication.class, args);

        System.out.println("Printing all books with BookRepository");
		
        var repo = context.getBean(JpaBookRepository.class);

        System.out.println("\n *****   Books in the repository   ***** \n");
        repo.findAll().forEach(System.out::println);
	
        System.out.println("\n *****   Java Books by tittle  ***** \n");
		repo.findByNameproduct("java").forEach(System.out::println); 
		
        System.out.println("\n *****   Add a new Java Book  ***** \n");
        repo.save(new BookDTO("1234567890192", 10, 10, "DAW", "Segon Course", "FP", "Spanish", "Perico", "2024/02/20 10:00:00", "2024/02/23 10:00:00", 10, 10, 10, 10, true));
	
        System.out.println("\n *****   Java Books by partial tittle  ***** \n"); 
		repo.findByPartialTitle("java").forEach(System.out::println);
		
        System.out.println("\n *****   Update a Java Book  ***** \n");
        repo.save(new BookDTO("2234567890192", 10, 10, "DAW", "Segon Course", "FP", "English", "Palotes", "2024/02/20 10:00:00", "2024/02/24 10:00:00", 10, 10, 10, 10, false));

        System.out.println("\n *****   Books by id   ***** \n");
		repo.findByIsbn("137").ifPresent(System.out::println);
	
        System.out.println("\n *****   Delete a Book  ***** \n");
		repo.deleteByIsbn("137");

        System.out.println("\n *****   Books by id    ***** \n");
		repo.findByIsbn("137").ifPresent(System.out::println);

		System.out.println("\n *****    Java Books avaliables: " + repo.countByPartialTitle("Java"));
	}

}
