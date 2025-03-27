package com.example.softlearning_springboot.applicationcore.entity.orders.mappers;

import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderSpanishDTO;
import com.example.softlearning_springboot.applicationcore.entity.orders.model.Order;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OrderSpanishMapper {

    public static Order orderFromDTO(OrderSpanishDTO oDTO) throws BuildException, DateException {
        return Order.getInstance(
            oDTO.getClientid(),
            oDTO.getReceiveraddress(),
            oDTO.getReceiverPerson(),
            oDTO.getReference(),
            oDTO.getDescription(),
            oDTO.getInitdate(),
            oDTO.getPaymentDate(),
            oDTO.getDeliveryDate(),
            oDTO.getFinishdate(),
            oDTO.getShoppingcart(),
            oDTO.getPhoneContact(),
            oDTO.getHigh(),
            oDTO.getWidth(),
            oDTO.getLength(),
            oDTO.getWeight(),
            oDTO.getFragile()
        );
    }

    public static OrderSpanishDTO dtoFromOrder(Order order) throws BuildException {
        return new OrderSpanishDTO(
            order.getClientId(),
            order.getReference(),
            order.getHigh(),
            order.getWidth(),
            order.getLength(),
            order.getWeight(),
            order.getFragile(),
            order.getReceiveraddress(),
            order.getReceiverPerson(),
            order.getDescription(),
            order.getShoppingCart().toString(),
            order.getPhoneContact(),
            order.getInitdate(),
            order.getFinishdate(),
            order.getPaymentDate(),
            order.getDeliveryDate()
        );
    }
}
