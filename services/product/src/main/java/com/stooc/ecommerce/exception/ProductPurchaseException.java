package com.stooc.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class ProductPurchaseException extends RuntimeException{
    public ProductPurchaseException(String message) {
        super(message);
    }
}
