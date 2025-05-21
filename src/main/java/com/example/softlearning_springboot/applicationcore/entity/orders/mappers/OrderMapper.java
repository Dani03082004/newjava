package com.example.softlearning_springboot.applicationcore.entity.orders.mappers;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderDTO;
import com.example.softlearning_springboot.applicationcore.entity.orders.dtos.OrderDetailDTO;
import com.example.softlearning_springboot.applicationcore.entity.orders.model.Order;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class OrderMapper {

    public static Order orderFromDTO(OrderDTO oDTO) throws BuildException, DateException {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE; 
        
        List<String> shoppingcartList = oDTO.getShoppingcart().stream().map(OrderDetailDTO::toString).collect(Collectors.toList());
        String shoppingcartString = String.join(", ", shoppingcartList);  

        return Order.getInstance(
            oDTO.getClientid(),
            oDTO.getReceiver_address(),
            oDTO.getReceiver_person(),
            oDTO.getReference(),
            oDTO.getDescription(),
            oDTO.getInitdate(), 
            oDTO.getPaymentdate(),
            oDTO.getDeliverydate(),
            oDTO.getFinishdate(),
            shoppingcartString,
            oDTO.getPhone_contact(),
            oDTO.getHigh(),
            oDTO.getWidth(),
            oDTO.getLength(),
            oDTO.getWeight(),
            oDTO.getFragile()
        );
    }

    public static OrderDTO dtoFromOrder(Order order) throws BuildException, DateException {
        return new OrderDTO(
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
            order.getShoppingCartDtos(),
            order.getPhoneContact(),
            order.getInitdate(),
            order.getPaymentDate(),
            order.getDeliveryDate(),
            order.getFinishdate()
        );
    }
}
