/*package com.example.softlearning_springboot.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderDTO;
import com.example.softlearning_springboot.applicationcore.entity.orders.persistence.OrderRepository;
import com.example.softlearning_springboot.applicationcore.entity.provider.dtos.ProviderDTO;

import jakarta.transaction.Transactional;

@Repository
public interface JpaOrderRepository extends JpaRepository<OrderDTO, Integer>, OrderRepository {
    
    Optional<OrderDTO> findByReference(int reference);

    public List<OrderDTO> findByReceiverPerson(String receiver_person);

    @Query("SELECT o FROM OrderDTO o WHERE o.receiver_person LIKE %:receiver_person%")
    List<OrderDTO> findByPartialReceiverPerson(String receiver_person);

    @Query("SELECT COUNT(o) FROM OrderDTO o WHERE o.receiver_person LIKE %:receiver_person%")
    Integer countByPartialReceiverPerson(String receiver_person);
    
    @Transactional
    OrderDTO save(OrderDTO order);

    @Transactional
    void deleteByReference(int reference);
}
*/