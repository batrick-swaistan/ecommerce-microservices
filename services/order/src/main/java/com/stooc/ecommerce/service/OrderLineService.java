package com.stooc.ecommerce.service;

import com.stooc.ecommerce.entity.Order;
import com.stooc.ecommerce.entity.OrderLine;
import com.stooc.ecommerce.records.OrderLineRequest;
import com.stooc.ecommerce.records.OrderLineResponse;
import com.stooc.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        OrderLine orderLine = new OrderLine();
        orderLine.setId(orderLineRequest.id());
        orderLine.setOrder(Order.builder().id(orderLineRequest.id()).build());
        orderLine.setQuantity(orderLineRequest.quantity());
        orderLine.setProductId(orderLineRequest.productId());
        orderLineRepository.save(orderLine);
        return orderLine.getId();
    }

    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        List<OrderLineResponse> responses = orderLineRepository.findAllByOrderId(orderId)
                .stream()
                .map(orderLineMapper::toOrderLineResponse)
                .collect(Collectors.toList());
        return responses;
    }
}