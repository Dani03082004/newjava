package com.example.softlearning_springboot.applicationcore.entity.client.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning_springboot.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning_springboot.applicationcore.entity.client.mappers.ClientMapper;
import com.example.softlearning_springboot.applicationcore.entity.client.persistence.ClientRepository;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class ClientServicesImpl implements ClientServices {

    @Autowired
    private ClientRepository clientRepository;
    private Serializer<ClientDTO> serializer;

    protected ClientDTO getDTO(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    protected ClientDTO getById(int id) throws ServiceException {
        ClientDTO cdto = this.getDTO(id);
        if (cdto == null) {
            throw new ServiceException("Client with ID " + id + " not found");
        }
        return cdto;
    }

    protected ClientDTO checkInputData(String client) throws ServiceException {
        try {
            ClientDTO cdto = this.serializer.deserialize(client, ClientDTO.class);
            ClientMapper.clientFromDTO(cdto);
            return cdto;
        } catch (Exception e) {
            throw new ServiceException("Error in the input client data: " + e.getMessage());
        }
    }

    protected ClientDTO newClient(String client) throws ServiceException {
        ClientDTO cdto = this.checkInputData(client);

        if (this.getDTO(cdto.getId()) == null) {
            return clientRepository.save(cdto);
        }
        throw new ServiceException("Client with ID " + cdto.getId() + " already exists");
    }

    protected ClientDTO updateClient(String client) throws ServiceException {
        try {
            ClientDTO cdto = this.checkInputData(client);
            this.getById(cdto.getId());
            return clientRepository.save(cdto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @Override
    public String getByIdToJson(int id) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.JSON_CLIENT).serialize(this.getById(id));
        } catch (Exception e) {
            throw new ServiceException("Error getting client as JSON: " + e.getMessage());
        }
    }

    @Override
    public String getByIdToXml(int id) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.XML_CLIENT).serialize(this.getById(id));
        } catch (Exception e) {
            throw new ServiceException("Error getting client as XML: " + e.getMessage());
        }
    }

    @Override
    public String addFromJson(String client) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_CLIENT);
            return serializer.serialize(this.newClient(client));
        } catch (Exception e) {
            throw new ServiceException("Error adding client from JSON: " + e.getMessage());
        }
    }

    @Override
    public String addFromXml(String client) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_CLIENT);
            return serializer.serialize(this.newClient(client));
        } catch (Exception e) {
            throw new ServiceException("Error adding client from XML: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromJson(String client) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_CLIENT);
            return serializer.serialize(this.updateClient(client));
        } catch (Exception e) {
            throw new ServiceException("Error updating client from JSON: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromXml(String client) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_CLIENT);
            return serializer.serialize(this.updateClient(client));
        } catch (Exception e) {
            throw new ServiceException("Error updating client from XML: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        try {
            this.getById(id);
            clientRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
