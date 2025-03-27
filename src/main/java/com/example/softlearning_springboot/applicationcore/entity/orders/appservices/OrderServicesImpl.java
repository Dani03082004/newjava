/* package com.example.softlearning_springboot.applicationcore.entity.orders.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning_springboot.applicationcore.entity.client.mappers.ClientMapper;
import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderDTO;
import com.example.softlearning_springboot.applicationcore.entity.orders.mappers.OrderMapper;
import com.example.softlearning_springboot.applicationcore.entity.orders.persistence.OrderRepository;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class OrderServicesImpl implements OrderServices {
 @Autowired
    private OrderRepository orderRepository;
    private Serializer<OrderDTO> serializer;

    protected OrderDTO getDTO(int clientid) {
        return orderRepository.findById(clientid).orElse(null);
    }

    protected OrderDTO getById(int clientid) throws ServiceException {
        OrderDTO cdto = this.getDTO(clientid);
        if (cdto == null) {
            throw new ServiceException("Order with ID " + clientid + " not found");
        }
        return cdto;
    }

    protected OrderDTO checkInputData(String order) throws ServiceException {
        try {
            OrderDTO cdto = this.serializer.deserialize(order, OrderDTO.class);
            OrderMapper.orderFromDTO(cdto);
            return cdto;
        } catch (Exception e) {
            throw new ServiceException("Error in the input order data: " + e.getMessage());
        }
    }

    protected OrderDTO newOrder(String order) throws ServiceException {
        OrderDTO cdto = this.checkInputData(order);

        if (this.getDTO(cdto.getClientid()) == null) {
            return orderRepository.save(cdto);
        }
        throw new ServiceException("Order with ID " + cdto.getClientid() + " already exists");
    }

    protected OrderDTO updateOrder(String order) throws ServiceException {
        try {
            OrderDTO cdto = this.checkInputData(order);
            this.getById(cdto.getClientid());
            return orderRepository.save(cdto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @Override
    public String getByIdToJson(int clientid) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.JSON_ORDER).serialize(this.getById(clientid));
        } catch (Exception e) {
            throw new ServiceException("Error getting Order as JSON: " + e.getMessage());
        }
    }

    @Override
    public String getByIdToXml(int clientid) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.XML_ORDER).serialize(this.getById(clientid));
        } catch (Exception e) {
            throw new ServiceException("Error getting order as XML: " + e.getMessage());
        }
    }

    @Override
    public String addFromJson(String order) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_ORDER);
            return serializer.serialize(this.newOrder(order));
        } catch (Exception e) {
            throw new ServiceException("Error adding Order from JSON: " + e.getMessage());
        }
    }

    @Override
    public String addFromXml(String order) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_ORDER);
            return serializer.serialize(this.newOrder(order));
        } catch (Exception e) {
            throw new ServiceException("Error adding order from XML: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromJson(String order) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_ORDER);
            return serializer.serialize(this.updateOrder(order));
        } catch (Exception e) {
            throw new ServiceException("Error updating order from JSON: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromXml(String order) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_ORDER);
            return serializer.serialize(this.updateOrder(order));
        } catch (Exception e) {
            throw new ServiceException("Error updating order from XML: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int clientid) throws ServiceException {
        try {
            this.getById(clientid);
            orderRepository.deleteById(clientid);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
 */