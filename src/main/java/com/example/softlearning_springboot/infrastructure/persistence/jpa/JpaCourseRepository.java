package com.example.softlearning_springboot.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.softlearning_springboot.applicationcore.entity.course.dtos.CourseDTO;
import com.example.softlearning_springboot.applicationcore.entity.course.persistence.CourseRepository;

import jakarta.transaction.Transactional;

public interface JpaCourseRepository extends JpaRepository<CourseDTO, Integer>, CourseRepository {
    
    public Optional<CourseDTO> findById(int id);

    public List<CourseDTO> findByNameproduct(String nameproduct);

    @Query(value = "SELECT co FROM CourseDTO co WHERE co.nameproduct LIKE %:nameproduct%")
    public List<CourseDTO> findByPartialName(String nameproduct);

    @Query(value = "SELECT count(*) FROM CourseDTO co WHERE co.nameproduct LIKE %:nameproduct%")
    public Integer countByPartialName(String nameproduct);

    @Transactional
    public CourseDTO save(CourseDTO course);

    @Transactional
    public void deleteById(int id);
}
