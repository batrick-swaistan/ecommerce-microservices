package com.stooc.ecommerce.service;

import com.stooc.ecommerce.entity.Order;
import com.stooc.ecommerce.records.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public OrderResponse fromOrder(Order order) {

        return new OrderResponse(
                order.getId(),
                order.getReference(),
                order.getTotalAmount(),
                order.getPaymentMethod(),
                order.getCustomerId()
        );
    }
}
