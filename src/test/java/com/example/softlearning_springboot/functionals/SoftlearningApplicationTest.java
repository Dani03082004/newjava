package com.example.softlearning_springboot.functionals;

import org.springframework.context.ApplicationContext;

import com.example.softlearning_springboot.applicationcore.entity.book.appservices.BookServicesImpl;
import com.example.softlearning_springboot.applicationcore.entity.client.appservices.ClientServicesImpl;
import com.example.softlearning_springboot.applicationcore.entity.course.appservices.CourseServicesImpl;
import com.example.softlearning_springboot.applicationcore.entity.employee.appservices.EmployeeServicesImpl;
import com.example.softlearning_springboot.applicationcore.entity.provider.appservices.ProviderServicesImpl;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoftlearningApplicationTest {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SoftlearningApplicationTest.class, args);

        System.out.println("\n*****   A P P L I C A T I O N    S T A R T E D   *****\n");

        System.out.println("\n *****   A P P S E R V I C E S   ***** \n");

        System.out.println("\n *****   AppServices Books, Clients, Courses, Employee & Provider  ***** \n");
        var bookServices = context.getBean(BookServicesImpl.class);
        var clientServices = context.getBean(ClientServicesImpl.class);
        var courseServices = context.getBean(CourseServicesImpl.class);
        var employeeServices = context.getBean(EmployeeServicesImpl.class);
        var providerServices = context.getBean(ProviderServicesImpl.class);
        
        try {
            System.out.println("\n *****   BOOK JSON DOCUMENT   ***** \n");
            System.out.println(bookServices.getByIsbnToJson("1234567890192"));
            System.out.println("\n *****   BOOK XML DOCUMENT   ***** \n");
            System.out.println(bookServices.getByIsbnToXml("1234567890192"));
            System.out.println("\n *****   CLIENT JSON DOCUMENT   ***** \n");
            System.out.println(clientServices.getByIdToJson(1));
            System.out.println("\n *****   CLIENT XML DOCUMENT   ***** \n");
            System.out.println(clientServices.getByIdToXml(1));
            System.out.println("\n *****   COURSE JSON DOCUMENT   ***** \n");
            System.out.println(courseServices.getByIdToJson(1));
            System.out.println("\n *****   COURSE XML DOCUMENT   ***** \n");
            System.out.println(courseServices.getByIdToXml(1));
            System.out.println("\n *****   EMPLOYEE JSON DOCUMENT   ***** \n");
            System.out.println(employeeServices.getByIdToJson(1));
            System.out.println("\n *****   EMPLOYEE XML DOCUMENT   ***** \n");
            System.out.println(employeeServices.getByIdToXml(1));
            System.out.println("\n *****   PROVIDER JSON DOCUMENT   ***** \n");
            System.out.println(providerServices.getByIdToJson(1));
            System.out.println("\n *****   PROVIDER XML DOCUMENT   ***** \n");
            System.out.println(providerServices.getByIdToXml(1));
        } catch (ServiceException e) {
            System.out.println("\n - - - - " + e.getMessage() + " - - - - \n");
        }

        try {
            System.out.println("\n *****   DELETE BOOK   ***** \n");
            bookServices.deleteByIsbn("101");
        } catch (ServiceException e) {
            System.out.println("\n - - - - " + e.getMessage() + " - - - - \n");
        }

        try {
            System.out.println("\n *****   DELETE CLIENT   ***** \n");
            clientServices.deleteById(200);
        } catch (ServiceException e) {
            System.out.println("\n - - - - " + e.getMessage() + " - - - - \n");
        }

        try {
            System.out.println("\n *****   DELETE COURSE   ***** \n");
            courseServices.deleteById(200);
        } catch (ServiceException e) {
            System.out.println("\n - - - - " + e.getMessage() + " - - - - \n");
        }

        try {
            System.out.println("\n *****   DELETE EMPLOYEE   ***** \n");
            employeeServices.deleteById(200);
        } catch (ServiceException e) {
            System.out.println("\n - - - - " + e.getMessage() + " - - - - \n");
        }

        try {
            System.out.println("\n *****   DELETE PROVIDER   ***** \n");
            providerServices.deleteById(200);
        } catch (ServiceException e) {
            System.out.println("\n - - - - " + e.getMessage() + " - - - - \n");
        }
    }
}