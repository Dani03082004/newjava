package com.example.softlearning_springboot.functionals;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.example.softlearning_springboot.applicationcore.entity.employee.dtos.EmployeeDTO;
import com.example.softlearning_springboot.infrastructure.persistence.jpa.JpaEmployeeRepository;

// Se ejecuta TODO desde aqui

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SoftlearningEmployeeApplication {
    @Test
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SoftlearningEmployeeApplication.class, args);

        System.out.println("Printing all employees with EmployeeRepository");
		
        var repo = context.getBean(JpaEmployeeRepository.class);

        System.out.println("\n *****   Employees in the repository   ***** \n");
        repo.findAll().forEach(System.out::println);
	
        System.out.println("\n *****  Employees by tittle  ***** \n");
		repo.findByName("Pepe").forEach(System.out::println); 
		
        System.out.println("\n *****   Add a new Java Book  ***** \n");
        repo.save(new EmployeeDTO(1, 647837483, 72837, 100, "Pepe", "Calle OP", "Perico", "perico@gmail.com", "2024/03/19 15:00:00", "super-user", "peperico", "alumnat", "2025/01/27 13:00:00"));
	
        System.out.println("\n *****   Employees by partial tittle  ***** \n"); 
		repo.findByPartialTitle("Pepe").forEach(System.out::println);
		
        System.out.println("\n *****   Update a Employee  ***** \n");
        repo.save(new EmployeeDTO(1, 647857483, 72837, 100, "Pepe", "Calle OP", "Perico", "perico@gmail.com", "2024/03/19 15:00:00", "super-user", "peperico", "alumnat", "2025/01/27 13:00:00"));

        System.out.println("\n *****   Employees by id   ***** \n");
		repo.findById(1).ifPresent(System.out::println);
	
        System.out.println("\n *****   Delete a Employee  ***** \n");
		repo.deleteById(2);

        System.out.println("\n *****   Employee by id    ***** \n");
		repo.findById(1).ifPresent(System.out::println);

		System.out.println("\n *****    Employees avaliables: " + repo.countByPartialTitle("Pepe"));
	}

}
