package com.stooc.ecommerce.service;

import com.stooc.ecommerce.entity.OrderLine;
import com.stooc.ecommerce.records.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {
    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
}
