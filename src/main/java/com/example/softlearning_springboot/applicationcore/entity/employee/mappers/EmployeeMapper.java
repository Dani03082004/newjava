package com.example.softlearning_springboot.applicationcore.entity.employee.mappers;

import com.example.softlearning_springboot.applicationcore.entity.employee.dtos.EmployeeDTO;
import com.example.softlearning_springboot.applicationcore.entity.employee.model.Employee;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class EmployeeMapper {

    public static Employee employeeFromDTO(EmployeeDTO employeeDTO) throws BuildException, DateException {
        return Employee.getInstance(
            employeeDTO.getId(),
            employeeDTO.getName(),
            employeeDTO.getAddress(),
            employeeDTO.getCognoms(),
            employeeDTO.getPhone_number(),
            employeeDTO.getPostal_code(),
            employeeDTO.getEmail(),
            employeeDTO.getBirthday(),
            employeeDTO.getSalary(),
            employeeDTO.getRole(),
            employeeDTO.getUser(),
            employeeDTO.getPassword(),
            employeeDTO.getDays().toString() // LocalDate a String
        );
    }

    public static EmployeeDTO dtoFromEmployee(Employee employee) throws BuildException, DateException{
        return new EmployeeDTO(
            employee.getId(),
            employee.getPhoneNumber(),
            employee.getPostalCode(),
            employee.getSalary(),
            employee.getName(),
            employee.getAddress(),
            employee.getCognoms(),
            employee.getEmail(),
            employee.getBirthday(),
            employee.getRole(),
            employee.getUser(),
            employee.getPassword(),
            employee.getDays().toString()
        );
    }
}
