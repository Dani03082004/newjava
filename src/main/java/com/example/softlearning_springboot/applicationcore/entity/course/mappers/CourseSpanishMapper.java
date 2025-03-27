package com.example.softlearning_springboot.applicationcore.entity.course.mappers;

import com.example.softlearning_springboot.applicationcore.entity.course.dtos.CourseSpanishDTO;
import com.example.softlearning_springboot.applicationcore.entity.course.model.Course;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CourseSpanishMapper {

    public static Course courseFromDTO(CourseSpanishDTO cDTO) throws BuildException {
        return Course.getInstance(
            cDTO.getNameproduct(),
            cDTO.getPrice(),
            cDTO.getDescription(),
            cDTO.getCategory(),
            cDTO.getDuration(),
            cDTO.getLanguages(),
            cDTO.getCourses(),
            cDTO.getTutor()
        );
    }

    public static CourseSpanishDTO dtoFromCourse(Course course) throws BuildException {
        return new CourseSpanishDTO(
            course.getId(),
            course.getNameproduct(),
            course.getPrice(),
            course.getDescription(),
            course.getCategory(),
            course.getDuration(),
            course.getLanguages(),
            course.getCourses(),
            course.getTutor()
        );
    }
}
