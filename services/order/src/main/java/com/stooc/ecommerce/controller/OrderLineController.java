package com.stooc.ecommerce.controller;


import com.stooc.ecommerce.records.OrderLineResponse;
import com.stooc.ecommerce.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService orderlineService;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findByOrderId(@PathVariable("order-id") Integer orderId) {
        List<OrderLineResponse> orderLineResponses = orderlineService.findAllByOrderId(orderId);
        return ResponseEntity.ok(orderLineResponses);
    }
}
