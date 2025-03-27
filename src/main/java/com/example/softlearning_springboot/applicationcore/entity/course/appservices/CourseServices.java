package com.example.softlearning_springboot.applicationcore.entity.course.appservices;

import org.springframework.stereotype.Service;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface CourseServices {
    public String getByIdToJson(int id) throws ServiceException;
    public String getByIdToXml(int id) throws ServiceException;
    public String addFromJson(String course) throws ServiceException;
    public String addFromXml(String course) throws ServiceException;
    public String updateOneFromJson(String course) throws ServiceException;
    public String updateOneFromXml(String course) throws ServiceException;
    public void deleteById(int id) throws ServiceException;
}
