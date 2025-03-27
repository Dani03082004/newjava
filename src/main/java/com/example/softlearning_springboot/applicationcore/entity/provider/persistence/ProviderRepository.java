package com.example.softlearning_springboot.applicationcore.entity.provider.persistence;

import java.util.List;
import java.util.Optional;

import com.example.softlearning_springboot.applicationcore.entity.provider.dtos.ProviderDTO;


public interface ProviderRepository {

    public Optional<ProviderDTO> findById(int id);

    public List<ProviderDTO> findByName(String name);

    public ProviderDTO save(ProviderDTO provider);

    public void deleteById(int id);
}
