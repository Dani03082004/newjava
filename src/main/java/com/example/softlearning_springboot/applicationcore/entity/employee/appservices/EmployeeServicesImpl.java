package com.example.softlearning_springboot.applicationcore.entity.employee.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning_springboot.applicationcore.entity.employee.dtos.EmployeeDTO;
import com.example.softlearning_springboot.applicationcore.entity.employee.mappers.EmployeeMapper;
import com.example.softlearning_springboot.applicationcore.entity.employee.persistence.EmployeeRepository;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class EmployeeServicesImpl implements EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;
    private Serializer<EmployeeDTO> serializer;

    protected EmployeeDTO getDTO(int id) {
        return employeeRepository.findById(id).orElse(null);
    }

    protected EmployeeDTO getById(int id) throws ServiceException {
        EmployeeDTO edto = this.getDTO(id);

        if (edto == null) {
            throw new ServiceException("Employee with ID " + id + " not found");
        }
        return edto;
    }

    protected EmployeeDTO checkInputData(String employee) throws ServiceException {
        try {
            EmployeeDTO edto = this.serializer.deserialize(employee, EmployeeDTO.class);
            EmployeeMapper.employeeFromDTO(edto);
            return edto;
        } catch (Exception e) {
            throw new ServiceException("Error in the input employee data: " + e.getMessage());
        }
    }

    protected EmployeeDTO newEmployee(String employee) throws ServiceException {
        EmployeeDTO edto = this.checkInputData(employee);

        if (this.getDTO(edto.getId()) == null) {
            return employeeRepository.save(edto);
        }
        throw new ServiceException("Employee with ID " + edto.getId() + " already exists");
    }

    protected EmployeeDTO updateEmployee(String employee) throws ServiceException {
        try {
            EmployeeDTO edto = this.checkInputData(employee);
            this.getById(edto.getId());
            return employeeRepository.save(edto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @Override
    public String getByIdToJson(int id) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.JSON_EMPLOYEE).serialize(this.getById(id));
        } catch (Exception e) {
            throw new ServiceException("Error getting employee as JSON: " + e.getMessage());
        }
    }

    @Override
    public String getByIdToXml(int id) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.XML_EMPLOYEE).serialize(this.getById(id));
        } catch (Exception e) {
            throw new ServiceException("Error getting employee as XML: " + e.getMessage());
        }
    }

    @Override
    public String addFromJson(String employee) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_EMPLOYEE);
            return serializer.serialize(this.newEmployee(employee));
        } catch (Exception e) {
            throw new ServiceException("Error adding employee from JSON: " + e.getMessage());
        }
    }

    @Override
    public String addFromXml(String employee) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_EMPLOYEE);
            return serializer.serialize(this.newEmployee(employee));
        } catch (Exception e) {
            throw new ServiceException("Error adding employee from XML: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromJson(String employee) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_EMPLOYEE);
            return serializer.serialize(this.updateEmployee(employee));
        } catch (Exception e) {
            throw new ServiceException("Error updating employee from JSON: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromXml(String employee) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_EMPLOYEE);
            return serializer.serialize(this.updateEmployee(employee));
        } catch (Exception e) {
            throw new ServiceException("Error updating employee from XML: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        try {
            this.getById(id);
            employeeRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
