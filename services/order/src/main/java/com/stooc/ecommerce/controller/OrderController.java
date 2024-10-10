package com.stooc.ecommerce.controller;


import com.stooc.ecommerce.entity.Order;
import com.stooc.ecommerce.records.OrderRequest;
import com.stooc.ecommerce.records.OrderResponse;
import com.stooc.ecommerce.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Integer> createOrder(@RequestBody @Valid OrderRequest orderRequest){
        Integer response = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAll(){
        List<OrderResponse> orderResponse = orderService.findAll();
        return ResponseEntity.ok(orderResponse);

    }


}
