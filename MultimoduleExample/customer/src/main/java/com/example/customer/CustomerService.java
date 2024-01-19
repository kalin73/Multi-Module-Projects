package com.example.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public record CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
    public List<CustomerDto> getAllCustomers() {
        return this.customerRepository.findAll()
                .stream()
                .map(CustomerDto::mapToCustomerDto)
                .toList();
    }
//    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
//        Customer customer = Customer.builder()
//                .firstName(customerRegistrationRequest.firstName())
//                .lastName(customerRegistrationRequest.lastName())
//                .email(customerRegistrationRequest.email())
//                .build();
//
//        this.customerRepository.saveAndFlush(customer);
//
//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject("http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId()
//        );
//
//        if (fraudCheckResponse.isFraudster()) {
//            throw new IllegalStateException();
//        }
//
//
//    }


}
