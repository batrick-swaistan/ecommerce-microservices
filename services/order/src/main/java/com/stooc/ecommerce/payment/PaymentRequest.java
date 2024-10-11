package com.stooc.ecommerce.payment;

import com.stooc.ecommerce.customer.CustomerResponse;
import com.stooc.ecommerce.records.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer

) {
}
