package com.example.softlearning_springboot.applicationcore.entity.employee.appservices;

import org.springframework.stereotype.Service;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface EmployeeServices {
    public String getByIdToJson(int id) throws ServiceException;
    public String getByIdToXml(int id) throws ServiceException;
    public String addFromJson(String employee) throws ServiceException;
    public String addFromXml(String employee) throws ServiceException;
    public String updateOneFromJson(String employee) throws ServiceException;
    public String updateOneFromXml(String employee) throws ServiceException;
    public void deleteById(int id) throws ServiceException;
}
