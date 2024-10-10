package com.stooc.ecommerce.service;

import com.stooc.ecommerce.customer.CustomerClient;
import com.stooc.ecommerce.entity.Order;
import com.stooc.ecommerce.entity.OrderLine;
import com.stooc.ecommerce.exception.BusinessException;
import com.stooc.ecommerce.kafka.OrderConfirmation;
import com.stooc.ecommerce.kafka.OrderProducer;
import com.stooc.ecommerce.product.ProductClient;
import com.stooc.ecommerce.records.OrderLineRequest;
import com.stooc.ecommerce.records.OrderRequest;
import com.stooc.ecommerce.records.OrderResponse;
import com.stooc.ecommerce.records.PurchaseRequest;
import com.stooc.ecommerce.repository.OrderLineRepository;
import com.stooc.ecommerce.repository.OrderRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderlineService orderlineService;
    private final OrderProducer orderProducer;
    private final OrderLineRepository orderLineRepository;
    private final OrderMapper orderMapper;

    public Integer createOrder(@Valid OrderRequest orderRequest) {
        var customer = customerClient.findCustomerById(orderRequest.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order:: No customer exists with the provided ID"));
        //first step is to check the customer - OpenFeign
        var purchasedProduct = productClient.purchaseProducts(orderRequest.products());

        Order order = new Order();
        order.setReference(orderRequest.reference());
        order.setCustomerId(orderRequest.customerId());
        order.setReference(orderRequest.reference());
        order.setTotalAmount(orderRequest.amount());
        order.setPaymentMethod(orderRequest.paymentMethod());
        orderRepository.save(order);


        for (PurchaseRequest purchaseRequest : orderRequest.products()) {
            orderlineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity() )
            );
        }

        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        orderRequest.reference(),
                        orderRequest.amount(),
                        orderRequest.paymentMethod(),
                        customer,
                        purchasedProduct
                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }
}