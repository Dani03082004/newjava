package com.example.softlearning_springboot.applicationcore.entity.orders.appservices;

import org.springframework.stereotype.Service;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface OrderDetailServices {
    public String getByIdToJson(int id) throws ServiceException;
    public String getByIdToXml(int id) throws ServiceException;
    public String addFromJson(String orderdetail) throws ServiceException;
    public String addFromXml(String orderdetail) throws ServiceException;
    public String updateOneFromJson(String orderdetail) throws ServiceException;
    public String updateOneFromXml(String orderdetail) throws ServiceException;
    public void deleteById(int id) throws ServiceException;
}
