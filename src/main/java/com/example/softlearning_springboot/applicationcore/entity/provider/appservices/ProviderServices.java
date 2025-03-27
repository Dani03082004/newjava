package com.example.softlearning_springboot.applicationcore.entity.provider.appservices;

import org.springframework.stereotype.Service;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface ProviderServices {
    public String getByIdToJson(int id) throws ServiceException;
    public String getByIdToXml(int id) throws ServiceException;
    public String addFromJson(String provider) throws ServiceException;
    public String addFromXml(String provider) throws ServiceException;
    public String updateOneFromJson(String provider) throws ServiceException;
    public String updateOneFromXml(String provider) throws ServiceException;
    public void deleteById(int id) throws ServiceException;
}
