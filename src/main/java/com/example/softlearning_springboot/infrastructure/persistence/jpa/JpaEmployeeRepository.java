package com.example.softlearning_springboot.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.softlearning_springboot.applicationcore.entity.employee.dtos.EmployeeDTO;
import com.example.softlearning_springboot.applicationcore.entity.employee.persistence.EmployeeRepository;

import jakarta.transaction.Transactional;

public interface JpaEmployeeRepository extends JpaRepository<EmployeeDTO, Integer>, EmployeeRepository {
    public Optional<EmployeeDTO> findById(int id);

    public List<EmployeeDTO> findByName(String name);

    @Query(value = "SELECT e FROM EmployeeDTO e WHERE e.name LIKE %:name%")
    public List<EmployeeDTO> findByPartialTitle(String name);

    @Query(value = "SELECT count(*) FROM EmployeeDTO e WHERE e.name LIKE %:name%")
    public Integer countByPartialTitle(String name);

    @Transactional
    public EmployeeDTO save(EmployeeDTO employee);

    @Transactional
    public void deleteById(int id);
}
