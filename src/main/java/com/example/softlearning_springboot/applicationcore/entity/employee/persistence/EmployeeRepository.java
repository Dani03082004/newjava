package com.example.softlearning_springboot.applicationcore.entity.employee.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning_springboot.applicationcore.entity.employee.dtos.EmployeeDTO;

public interface EmployeeRepository {

    public Optional<EmployeeDTO> findById(int id);

    public List<EmployeeDTO> findByName(String name);

    public EmployeeDTO save(EmployeeDTO employee);

    public void deleteById(int id);
}

