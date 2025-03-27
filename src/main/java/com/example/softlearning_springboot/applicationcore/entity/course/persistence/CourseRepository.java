package com.example.softlearning_springboot.applicationcore.entity.course.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning_springboot.applicationcore.entity.course.dtos.CourseDTO;

public interface CourseRepository {

    public Optional<CourseDTO> findById(int id);

    public List<CourseDTO> findByNameproduct(String nameproduct);

    public CourseDTO save(CourseDTO course);

    public void deleteById(int id);
}

