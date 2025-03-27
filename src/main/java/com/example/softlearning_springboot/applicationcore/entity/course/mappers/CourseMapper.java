package com.example.softlearning_springboot.applicationcore.entity.course.mappers;

import com.example.softlearning_springboot.applicationcore.entity.course.dtos.CourseDTO;
import com.example.softlearning_springboot.applicationcore.entity.course.model.Course;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CourseMapper {

    public static Course courseFromDTO(CourseDTO courseDTO) throws BuildException{
        return Course.getInstance(
            courseDTO.getNameproduct(),
            courseDTO.getPrice(),
            courseDTO.getDescription(),
            courseDTO.getCategory(),
            courseDTO.getDuration(),
            courseDTO.getLanguages(),
            courseDTO.getCourses(),
            courseDTO.getTutor()
        );
    }

    public static CourseDTO dtoFromCourse(Course course) {
        return new CourseDTO(
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
