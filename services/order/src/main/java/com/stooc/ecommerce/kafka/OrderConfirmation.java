package com.stooc.ecommerce.kafka;

import com.stooc.ecommerce.customer.CustomerResponse;
import com.stooc.ecommerce.product.PurchaseResponse;
import com.stooc.ecommerce.records.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderRefernce,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
 ) {
}
