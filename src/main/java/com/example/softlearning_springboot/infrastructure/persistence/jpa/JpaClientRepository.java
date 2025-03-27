package com.example.softlearning_springboot.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.softlearning_springboot.applicationcore.entity.client.dtos.ClientDTO;
import com.example.softlearning_springboot.applicationcore.entity.client.persistence.ClientRepository;

import jakarta.transaction.Transactional;

public interface JpaClientRepository extends JpaRepository<ClientDTO, Integer>, ClientRepository {
    public Optional<ClientDTO> findById(int id);

    public List<ClientDTO> findByName(String name);

    @Query(value = "SELECT c FROM ClientDTO c WHERE c.name LIKE %:name%")
    public List<ClientDTO> findByPartialTitle(String name);

    @Query(value = "SELECT count(*) FROM ClientDTO c WHERE c.name LIKE %:name%")
    public Integer countByPartialTitle(String name);
    
    @Transactional
    public ClientDTO save(ClientDTO client);

    @Transactional
    public void deleteById(int id);
}
