package com.example.softlearning_springboot.functionals;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.example.softlearning_springboot.applicationcore.entity.course.dtos.CourseDTO;
import com.example.softlearning_springboot.infrastructure.persistence.jpa.JpaCourseRepository;

// Se ejecuta TODO desde aqui

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SoftlearningCourseApplication {
    @Test
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SoftlearningCourseApplication.class, args);

        System.out.println("Printing all courses with CourseRepository");
		
        var repo = context.getBean(JpaCourseRepository.class);

        System.out.println("\n *****   Courses in the repository   ***** \n");
        repo.findAll().forEach(System.out::println);
	
        System.out.println("\n *****   Courses by tittle  ***** \n");
		repo.findByNameproduct("DAW").forEach(System.out::println); 
		
        System.out.println("\n *****   Add a new Course  ***** \n");
        repo.save(new CourseDTO(1, "DAW", 110, "awesome", "grateful", 100, "spanish", "first", "Antonio"));
	
        System.out.println("\n *****   Course by partial tittle  ***** \n"); 
		repo.findByPartialName("DAW").forEach(System.out::println);
		
        System.out.println("\n *****   Update a Course***** \n");
        repo.save(new CourseDTO(1, "DAW", 1111, "awesome", "grateful", 100, "spanish", "first", "Antonio"));

        System.out.println("\n *****   Course by id   ***** \n");
		repo.findById(1).ifPresent(System.out::println);
	
        System.out.println("\n *****   Delete a Course  ***** \n");
		repo.deleteById(3);

        System.out.println("\n *****   Course by id    ***** \n");
		repo.findById(1).ifPresent(System.out::println);

		System.out.println("\n *****    Courses avaliables: " + repo.countByPartialName("DAW"));
	}

}
