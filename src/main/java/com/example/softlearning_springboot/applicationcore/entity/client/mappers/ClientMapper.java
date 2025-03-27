package com.example.softlearning_springboot.applicationcore.entity.client.mappers;

import com.example.softlearning_springboot.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning_springboot.applicationcore.entity.client.model.Client;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class ClientMapper {

    public static Client clientFromDTO(ClientDTO clientDTO) throws BuildException{
        return Client.getInstance(
            clientDTO.getId(),
            clientDTO.getName(),
            clientDTO.getAddress(),
            clientDTO.getCognoms(),
            clientDTO.getPhone_number(),
            clientDTO.getPostal_code(),
            clientDTO.getEmail(),
            clientDTO.getBirthday(),
            clientDTO.getDni(),
            clientDTO.getAge(),
            clientDTO.getWorkers(),
            clientDTO.getSocial_reason()
        );
    }

    public static ClientDTO dtoFromClient(Client client) {
        return new ClientDTO(
            client.getId(),
            client.getName(),                      
            client.getAddress(),
            client.getCognoms(),
            client.getEmail(),
            client.getBirthday(),
            client.getDNI(),
            client.getCompanyData().getSocialreason(), 
            client.getPhoneNumber(),
            client.getPostalCode(),
            client.getAge(),
            client.getCompanyData().getWorkers()
        );
    }
    
}
