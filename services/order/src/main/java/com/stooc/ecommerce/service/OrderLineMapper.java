package com.stooc.ecommerce.service;

import com.stooc.ecommerce.entity.Order;
import com.stooc.ecommerce.entity.OrderLine;
import com.stooc.ecommerce.records.OrderLineRequest;
import com.stooc.ecommerce.records.OrderLineResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine.builder()
                .id(request.orderId())
                .productId(request.productId())
                .order(
                        Order.builder()
                                .id(request.orderId())
                                .build()
                )
                .quantity(request.quantity())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine) {
        return new OrderLineResponse(orderLine.getId(), orderLine.getQuantity());
    }
}
