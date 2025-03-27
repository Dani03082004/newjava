/*package com.example.softlearning_springboot.infrastructure.persistence.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderDetailDTO;
import com.example.softlearning_springboot.applicationcore.entity.orders.persistence.OrderDetailRepository;

import jakarta.transaction.Transactional;

@Repository
public interface JpaOrderDetailRepository extends JpaRepository<OrderDetailDTO, Integer>, OrderDetailRepository {

    Optional<OrderDetailDTO> findById(int id);

    List<OrderDetailDTO> findByNameProduct(String name_product);

    @Query("SELECT od FROM OrderDetailDTO od WHERE od.name_product LIKE %:name_product%")
    List<OrderDetailDTO> findByPartialNameProduct(String name_product);

    @Query("SELECT COUNT(od) FROM OrderDetailDTO od WHERE od.name_product LIKE %:name_product%")
    Integer countByPartialNameProduct(String name_product);
    
    @Transactional
    OrderDetailDTO save(OrderDetailDTO orderDetail);

    @Transactional
    void deleteById(int id);
}
*/