package com.example.softlearning_springboot.applicationcore.entity.provider.mappers;

import com.example.softlearning_springboot.applicationcore.entity.provider.dtos.ProviderSpanishDTO;
import com.example.softlearning_springboot.applicationcore.entity.provider.model.Provider;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ProviderSpanishMapper {

    public static Provider providerFromDTO(ProviderSpanishDTO pDTO) throws BuildException {
        return Provider.getInstance(
            pDTO.getSchedule(),
            pDTO.getWork(),
            pDTO.getUser(),
            pDTO.getPassword(),
            pDTO.getWorkers(),
            pDTO.getSocial_reason(),
            pDTO.getId(),
            pDTO.getName(),
            pDTO.getAddress(),
            pDTO.getCognoms(),
            pDTO.getPhone_number(),
            pDTO.getPostal_Code(),
            pDTO.getEmail(),
            pDTO.getBirthday()
        );
    }

    public static ProviderSpanishDTO dtoFromProvider(Provider provider) throws BuildException {
        return new ProviderSpanishDTO(
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
