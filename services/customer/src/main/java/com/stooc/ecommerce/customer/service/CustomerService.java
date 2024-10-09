package com.stooc.ecommerce.customer.service;

import com.stooc.ecommerce.customer.Customer;
import com.stooc.ecommerce.customer.exception.CustomerNotFoundException;
import com.stooc.ecommerce.customer.records.CustomerRequest;
import com.stooc.ecommerce.customer.records.CustomerResponse;
import com.stooc.ecommerce.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public String createCustomer(CustomerRequest request) {
        var customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();
    }

    public String updateCustomer(CustomerRequest request) {

        var customer = customerRepository.findById(request.id()).orElseThrow(() -> new CustomerNotFoundException(
                format("Cannot update customer::No customer found with the provided ID:: %s", request.id())
        ));

        mergeCustomer(customer, request);
        customerRepository.save(customer);

        return "Customer updated successfully";
    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> getAllCustomers() {

        List<CustomerResponse> everyCustomers = customerRepository.findAll()
                .stream()
                .map(customerMapper::fromCustomer)
                .collect(Collectors.toList());

        return everyCustomers;

    }

    public Boolean customerExistsById(String customerId) {
        Boolean existsById = customerRepository.findById(customerId).isPresent();
        return existsById;
    }

    public CustomerResponse findCustomerById(String customerId) {
        CustomerResponse customer = customerRepository.findById(customerId)
                .map(customerMapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer::No customer found with the provided ID:: %s", customerId)
                ));
        return customer;
    }

    public String deleteCustomerById(String customerId) {
        customerRepository.deleteById(customerId);
        return "Customer deleted successfully! ";
    }
}



