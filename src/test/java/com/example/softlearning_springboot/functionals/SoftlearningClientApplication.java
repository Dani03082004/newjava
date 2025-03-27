package com.example.softlearning_springboot.functionals;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import com.example.softlearning_springboot.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning_springboot.infrastructure.persistence.jpa.JpaClientRepository;

// Se ejecuta TODO desde aquí

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SoftlearningClientApplication {
    @Test
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SoftlearningClientApplication.class, args);

        System.out.println("Printing all clients with ClientRepository");
		
        var repo = context.getBean(JpaClientRepository.class);

        System.out.println("\n *****   Clients in the repository   ***** \n");
        repo.findAll().forEach(System.out::println);

        System.out.println("\n *****   Clients by name  ***** \n");
        repo.findByName("John").forEach(System.out::println);

        System.out.println("\n *****   Add a new Client  ***** \n");
        repo.save(new ClientDTO(1, "Susana", "123457 Maine Street", "Oria", "susanaoria@gmail.com", "1990-01-02 11:00:00", "76058768W", "Football", 132465789, 10002, 34, 10));

        System.out.println("\n *****   Clients by partial name  ***** \n");
        repo.findByPartialTitle("Joh").forEach(System.out::println);

        System.out.println("\n *****   Update a Client  ***** \n");
        repo.save(new ClientDTO(1, "James", "465 Elms Street", "Rodriguez", "rayo.vallecano@gmail.com", "1981-05-15 12:00:00","76058768W", "Football", 986654321, 10003, 31, 12));

        System.out.println("\n *****   Clients by ID   ***** \n");
        repo.findById(1).ifPresent(System.out::println);

        System.out.println("\n *****   Delete a Client  ***** \n");
        repo.deleteById(15);

        System.out.println("\n *****   Clients by ID   ***** \n");
        repo.findById(15).ifPresent(System.out::println);

        System.out.println("\n *****   Total Clients with name containing 'Anna': " + repo.countByPartialTitle("Anna"));
    }

}
