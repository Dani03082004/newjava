package com.example.softlearning_springboot.applicationcore.entity.client.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning_springboot.applicationcore.entity.client.dtos.ClientDTO;

public interface ClientRepository {

    public Optional<ClientDTO> findById(int id);

    public List<ClientDTO> findByName(String name);

    public ClientDTO save(ClientDTO client);

    public void deleteById(int id);
}
