package com.example.softlearning_springboot.applicationcore.entity.client.mappers;


import com.example.softlearning_springboot.applicationcore.entity.client.dtos.ClientSpanishDTO;
import com.example.softlearning_springboot.applicationcore.entity.client.model.Client;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ClientSpanishMapper {

    public static Client clientFromDTO(ClientSpanishDTO cDTO) throws BuildException, DateException {
        return Client.getInstance(
            cDTO.getId(),
            cDTO.getName(),
            cDTO.getAddress(),
            cDTO.getCognoms(),
            cDTO.getPhone_Number(),
            cDTO.getPostal_Code(),
            cDTO.getEmail(),
            cDTO.getBirthday(), 
            cDTO.getDni(),
            cDTO.getAge(),
            cDTO.getWorkers(),
            cDTO.getSocial_reason()
        );
    }

    public static ClientSpanishDTO dtoFromClient(Client client) throws BuildException {
        return new ClientSpanishDTO(
            client.getName(),
            client.getAddress(),
            client.getCognoms(),
            client.getEmail(),
            client.getBirthday(), 
            client.getDNI(),
            client.getCompanyData().getSocialreason(),
            client.getId(),
            client.getPhoneNumber(),
            client.getPostalCode(),
            client.getAge(),
            client.getCompanyData().getWorkers()
        );
    }
}
