package com.example.softlearning_springboot.applicationcore.entity.provider.appservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.softlearning_springboot.applicationcore.entity.provider.dtos.ProviderDTO;
import com.example.softlearning_springboot.applicationcore.entity.provider.mappers.ProviderMapper;
import com.example.softlearning_springboot.applicationcore.entity.provider.persistence.ProviderRepository;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializer;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.Serializers;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.appservices.serializers.SerializersCatalog;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.ServiceException;

@Controller
public class ProviderServicesImpl implements ProviderServices {

    @Autowired
    private ProviderRepository providerRepository;
    private Serializer<ProviderDTO> serializer;

    protected ProviderDTO getDTO(int id) {
        return providerRepository.findById(id).orElse(null);
    }

    protected ProviderDTO getById(int id) throws ServiceException {
        ProviderDTO pdto = this.getDTO(id);

        if (pdto == null) {
            throw new ServiceException("Provider with ID " + id + " not found");
        }
        return pdto;
    }

    protected ProviderDTO checkInputData(String provider) throws ServiceException {
        try {
            ProviderDTO pdto = this.serializer.deserialize(provider, ProviderDTO.class);
            ProviderMapper.providerFromDTO(pdto);
            return pdto;
        } catch (Exception e) {
            throw new ServiceException("Error in the input provider data: " + e.getMessage());
        }
    }

    protected ProviderDTO newProvider(String provider) throws ServiceException {
        ProviderDTO pdto = this.checkInputData(provider);

        if (this.getDTO(pdto.getId()) == null) {
            return providerRepository.save(pdto);
        }
        throw new ServiceException("Provider with ID " + pdto.getId() + " already exists");
    }

    protected ProviderDTO updateProvider(String provider) throws ServiceException {
        try {
            ProviderDTO pdto = this.checkInputData(provider);
            this.getById(pdto.getId());
            return providerRepository.save(pdto);
        } catch (ServiceException e) {
            throw e;
        }
    }

    @Override
    public String getByIdToJson(int id) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.JSON_PROVIDER).serialize(this.getById(id));
        } catch (Exception e) {
            throw new ServiceException("Error getting provider as JSON: " + e.getMessage());
        }
    }

    @Override
    public String getByIdToXml(int id) throws ServiceException {
        try {
            return SerializersCatalog.getInstance(Serializers.XML_PROVIDER).serialize(this.getById(id));
        } catch (Exception e) {
            throw new ServiceException("Error getting provider as XML: " + e.getMessage());
        }
    }

    @Override
    public String addFromJson(String provider) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_PROVIDER);
            return serializer.serialize(this.newProvider(provider));
        } catch (Exception e) {
            throw new ServiceException("Error adding provider from JSON: " + e.getMessage());
        }
    }

    @Override
    public String addFromXml(String provider) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_PROVIDER);
            return serializer.serialize(this.newProvider(provider));
        } catch (Exception e) {
            throw new ServiceException("Error adding provider from XML: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromJson(String provider) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.JSON_PROVIDER);
            return serializer.serialize(this.updateProvider(provider));
        } catch (Exception e) {
            throw new ServiceException("Error updating provider from JSON: " + e.getMessage());
        }
    }

    @Override
    public String updateOneFromXml(String provider) throws ServiceException {
        try {
            this.serializer = SerializersCatalog.getInstance(Serializers.XML_PROVIDER);
            return serializer.serialize(this.updateProvider(provider));
        } catch (Exception e) {
            throw new ServiceException("Error updating provider from XML: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) throws ServiceException {
        try {
            this.getById(id);
            providerRepository.deleteById(id);
        } catch (ServiceException e) {
            throw e;
        }
    }
}
