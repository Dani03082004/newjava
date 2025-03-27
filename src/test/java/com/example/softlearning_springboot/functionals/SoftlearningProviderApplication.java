package com.example.softlearning_springboot.functionals;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.example.softlearning_springboot.applicationcore.entity.provider.dtos.ProviderDTO;
import com.example.softlearning_springboot.infrastructure.persistence.jpa.JpaProviderRepository;

// Se ejecuta TODO desde aqui

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SoftlearningProviderApplication {
    @Test
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SoftlearningProviderApplication.class, args);

        System.out.println("Printing all providers with ProviderRepository");
		
        var repo = context.getBean(JpaProviderRepository.class);

        System.out.println("\n *****   Providers in the repository   ***** \n");
        repo.findAll().forEach(System.out::println);
	
        System.out.println("\n *****   Providers by tittle  ***** \n");
		repo.findByName("Albertito").forEach(System.out::println); 
		
        System.out.println("\n *****   Add a new Provider  ***** \n");
        repo.save(new ProviderDTO(1, 645434521, 43234, 100, "Albertito", "Calle AL", "Tito", "albertito@gmail.com", "2024/02/20 10:00:00", "morning", "programmer", "programmer", "helper", "helper"));
	
        System.out.println("\n *****   Providers by partial tittle  ***** \n"); 
		repo.findByPartialTitle("Albertito").forEach(System.out::println);
		
        System.out.println("\n *****   Update a Provider  ***** \n");
        repo.save(new ProviderDTO(1, 645434500, 43234, 100, "Albertito", "Calle AL", "Tito", "albertito@gmail.com", "2024/02/20 10:00:00", "morning", "programmer", "programmer", "helper", "helper"));

        System.out.println("\n *****   Provider by id   ***** \n");
		repo.findById(1).ifPresent(System.out::println);
	
        System.out.println("\n *****   Delete a Provider  ***** \n");
		repo.deleteById(13);

        System.out.println("\n *****   Provider by id    ***** \n");
		repo.findById(1).ifPresent(System.out::println);

		System.out.println("\n *****    Providers avaliables: " + repo.countByPartialTitle("Albertito"));
	}

}
