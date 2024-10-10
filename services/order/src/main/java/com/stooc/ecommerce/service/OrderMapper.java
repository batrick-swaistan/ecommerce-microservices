package com.stooc.ecommerce.service;

import com.stooc.ecommerce.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Object fromOrder(Order order) {

        return order;
    }
}
