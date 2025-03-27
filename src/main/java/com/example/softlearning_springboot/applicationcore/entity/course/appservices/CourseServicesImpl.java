package com.example.softlearning_springboot.applicationcore.entity.course.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning_springboot.applicationcore.entity.course.dtos.CourseDTO;
import com.example.softlearning_springboot.applicationcore.entity.course.mappers.CourseMapper;
import com.example.softlearning_springboot.applicationcore.entity.course.persistence.CourseRepository;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class CourseServicesImpl implements CourseServices {

    @Autowired
    private CourseRepository courseRepository;
    private Serializer<CourseDTO> serializer;

    protected CourseDTO getDTO(int id) {
        return courseRepository.findById(id).orElse(null);
    }

    protected CourseDTO getById(int id) throws ServiceException {
        CourseDTO cdto = this.getDTO(id);

        if (cdto == null) {
            throw new ServiceException("Course with ID " + id + " not found");
        }
        return cdto;
    }

    protected CourseDTO checkInputData(String course) throws ServiceException {
        try {
            CourseDTO cdto = this.serializer.deserialize(course, CourseDTO.class);
            CourseMapper.courseFromDTO(cdto);
            return cdto;
        } catch (Exception e) {
            throw new ServiceException("Error in the input course data: " + e.getMessage());
        }
    }

    protected CourseDTO newCourse(String course) throws ServiceException {
        CourseDTO cdto = this.checkInputData(course);

        if (this.getDTO(cdto.getId()) == null) {
            return courseRepository.save(cdto);
        }
        throw new ServiceException("Course with ID " + cdto.getId() + " already exists");
    }

    protected CourseDTO updateCourse(String course) throws ServiceException {
        try {
            CourseDTO cdto = this.checkInputData(course);
            this.getById(cdto.getId());
            return courseRepository.save(cdto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @Override
    public String getByIdToJson(int id) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.JSON_COURSE).serialize(this.getById(id));
        } catch (Exception e) {
            throw new ServiceException("Error getting course as JSON: " + e.getMessage());
        }
    }

    @Override
    public String getByIdToXml(int id) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.XML_COURSE).serialize(this.getById(id));
        } catch (Exception e) {
            throw new ServiceException("Error getting course as XML: " + e.getMessage());
        }
    }

    @Override
    public String addFromJson(String course) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_COURSE);
            return serializer.serialize(this.newCourse(course));
        } catch (Exception e) {
            throw new ServiceException("Error adding course from JSON: " + e.getMessage());
        }
    }

    @Override
    public String addFromXml(String course) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_COURSE);
            return serializer.serialize(this.newCourse(course));
        } catch (Exception e) {
            throw new ServiceException("Error adding course from XML: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromJson(String course) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_COURSE);
            return serializer.serialize(this.updateCourse(course));
        } catch (Exception e) {
            throw new ServiceException("Error updating course from JSON: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromXml(String course) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_COURSE);
            return serializer.serialize(this.updateCourse(course));
        } catch (Exception e) {
            throw new ServiceException("Error updating course from XML: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        try {
            this.getById(id);
            courseRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
