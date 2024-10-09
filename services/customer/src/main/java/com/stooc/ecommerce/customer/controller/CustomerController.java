package com.stooc.ecommerce.customer.controller;


import com.stooc.ecommerce.customer.records.CustomerRequest;
import com.stooc.ecommerce.customer.records.CustomerResponse;
import com.stooc.ecommerce.customer.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;


    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody @Valid CustomerRequest request){
        String response = service.createCustomer(request);
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<String> updateCustomer(@RequestBody @Valid CustomerRequest request){
        String response = service.updateCustomer(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getEveryCustomers(){
        List<CustomerResponse> everyCustomer = service.getAllCustomers();
        return ResponseEntity.ok(everyCustomer);
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> isCustomerExist(@PathVariable("customer-id") String customerId){
        Boolean response = service.customerExistsById(customerId);
        return ResponseEntity.ok(response);

    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findCustomerbyId(@PathVariable("customer-id") String customerId){
        CustomerResponse response = service.findCustomerById(customerId);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("customer-id") String customerId){
        String response = service.deleteCustomerById(customerId);
        return ResponseEntity.ok(response);
    }
}
