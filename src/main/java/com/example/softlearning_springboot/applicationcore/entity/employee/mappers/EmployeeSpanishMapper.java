package com.example.softlearning_springboot.applicationcore.entity.employee.mappers;

import com.example.softlearning_springboot.applicationcore.entity.employee.dtos.EmployeeSpanishDTO;
import com.example.softlearning_springboot.applicationcore.entity.employee.model.Employee;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class EmployeeSpanishMapper {

    public static Employee employeeFromDTO(EmployeeSpanishDTO eDTO) throws BuildException, DateException {
        return Employee.getInstance(
            eDTO.getId(),
            eDTO.getName(),
            eDTO.getAddress(),
            eDTO.getCognoms(),
            eDTO.getPhone_Number(),
            eDTO.getPostal_Code(),
            eDTO.getEmail(),
            eDTO.getBirthday(),
            eDTO.getSalary(),
            eDTO.getRole(),
            eDTO.getUser(),
            eDTO.getPassword(),
            eDTO.getDays()
        );
    }

    public static EmployeeSpanishDTO dtoFromEmployee(Employee employee) throws BuildException {
        return new EmployeeSpanishDTO(
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
