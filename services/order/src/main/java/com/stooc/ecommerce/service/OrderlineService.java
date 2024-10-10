package com.stooc.ecommerce.service;

import com.stooc.ecommerce.entity.Order;
import com.stooc.ecommerce.entity.OrderLine;
import com.stooc.ecommerce.records.OrderLineRequest;
import com.stooc.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderlineService {

    private final OrderLineRepository orderLineRepository;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        OrderLine orderLine = new OrderLine();
        orderLine.setId(orderLineRequest.id());
        orderLine.setOrder(Order.builder().id(orderLineRequest.id()).build());
        orderLine.setQuantity(orderLineRequest.quantity());
        orderLine.setProductId(orderLineRequest.productId());
        orderLineRepository.save(orderLine);
        return orderLine.getId();
    }
}
