package com.example.softlearning_springboot.applicationcore.entity.provider.mappers;

import com.example.softlearning_springboot.applicationcore.entity.provider.dtos.ProviderDTO;
import com.example.softlearning_springboot.applicationcore.entity.provider.model.Provider;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ProviderMapper {

    public static Provider providerFromDTO(ProviderDTO providerDTO) throws BuildException{
        return Provider.getInstance(
            providerDTO.getSchedule(),
            providerDTO.getWork(),
            providerDTO.getUser(),
            providerDTO.getPassword(),
            providerDTO.getWorkers(),
            providerDTO.getSocial_reason(),
            providerDTO.getId(),
            providerDTO.getName(),
            providerDTO.getAddress(),
            providerDTO.getCognoms(),
            providerDTO.getPhone_number(),
            providerDTO.getPostal_code(),
            providerDTO.getEmail(),
            providerDTO.getBirthday()
        );
    }

    public static ProviderDTO dtoFromProvider(Provider provider) {
        return new ProviderDTO(
            provider.getId(),
            provider.getPhoneNumber(),
            provider.getPostalCode(),
            provider.getComp().getWorkers(),
            provider.getName(),
            provider.getAddress(),
            provider.getCognoms(),
            provider.getEmail(),
            provider.getBirthday(),
            provider.getSchedule(),
            provider.getWork(),
            provider.getUser(),
            provider.getPassword(),
            provider.getComp().getSocialreason()
        );
    }
}
