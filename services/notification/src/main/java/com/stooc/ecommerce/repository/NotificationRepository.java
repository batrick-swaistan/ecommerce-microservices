package com.stooc.ecommerce.repository;


import com.stooc.ecommerce.entity.Notification;
import com.stooc.ecommerce.kafka.payment.PaymentConfirmation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification,String> {
}
