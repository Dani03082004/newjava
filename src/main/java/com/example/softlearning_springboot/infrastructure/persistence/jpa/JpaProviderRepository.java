package com.example.softlearning_springboot.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.softlearning_springboot.applicationcore.entity.provider.dtos.ProviderDTO;
import com.example.softlearning_springboot.applicationcore.entity.provider.persistence.ProviderRepository;

import jakarta.transaction.Transactional;

public interface JpaProviderRepository extends JpaRepository<ProviderDTO, Integer>, ProviderRepository {
    public Optional<ProviderDTO> findById(int id);

    public List<ProviderDTO> findByName(String name);

    @Query(value = "SELECT p FROM ProviderDTO p WHERE p.name LIKE %:name%")
    public List<ProviderDTO> findByPartialTitle(String name);

    @Query(value = "SELECT count(*) FROM ProviderDTO p WHERE p.name LIKE %:name%")
    public Integer countByPartialTitle(String name);

    @Transactional
    public ProviderDTO save(ProviderDTO provider);

    @Transactional
    public void deleteById(int id);
}
