package com.example.softlearning_springboot.applicationcore.entity.orders.appservices;

import org.springframework.stereotype.Service;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface OrderServices {
    public String getByIdToJson(int clientid) throws ServiceException;
    public String getByIdToXml(int clientid) throws ServiceException;
    public String addFromJson(String order) throws ServiceException;
    public String addFromXml(String order) throws ServiceException;
    public String updateOneFromJson(String order) throws ServiceException;
    public String updateOneFromXml(String order) throws ServiceException;
    public void deleteById(int clientid) throws ServiceException;
}
