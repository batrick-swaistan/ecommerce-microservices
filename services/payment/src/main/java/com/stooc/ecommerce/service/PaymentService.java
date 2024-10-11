package com.stooc.ecommerce.service;

import com.stooc.ecommerce.entity.Payment;
import com.stooc.ecommerce.notification.NotificationProducer;
import com.stooc.ecommerce.record.PaymentNotificationRequest;
import com.stooc.ecommerce.record.PaymentRequest;
import com.stooc.ecommerce.repository.PaymentRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(@Valid PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setId(paymentRequest.id());
        payment.setAmount(paymentRequest.amount());
        payment.setPaymentMethod(paymentRequest.paymentMethod());
        var paymentResponse = paymentRepository.save(payment);
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        paymentRequest.orderReference(),
                        paymentRequest.amount(),
                        paymentRequest.paymentMethod(),
                        paymentRequest.customer().firstname(),
                        paymentRequest.customer().lastname(),
                        paymentRequest.customer().email()
                )
        );
        return paymentResponse.getId();
    }
}
