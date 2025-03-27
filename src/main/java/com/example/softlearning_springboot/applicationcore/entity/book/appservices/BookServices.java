package com.example.softlearning_springboot.applicationcore.entity.book.appservices;

import org.springframework.stereotype.Service;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Service
public interface BookServices {
    public String getByIsbnToJson(String isbn) throws ServiceException;
    public String getByIsbnToXml(String isbn) throws ServiceException;
    public String addFromJson(String book) throws ServiceException;
    public String addFromXml(String book) throws ServiceException;
    public String updateOneFromJson(String book) throws ServiceException;
    public String updateOneFromXml(String book) throws ServiceException;
    public void deleteByIsbn(String isbn) throws ServiceException;
}
