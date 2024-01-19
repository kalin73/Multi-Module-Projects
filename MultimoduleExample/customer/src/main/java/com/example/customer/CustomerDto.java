package com.example.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
    private String firstName;

    private String lastName;

    private String email;

    public static CustomerDto mapToCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .email(customer.getEmail())
                .build();
    }
}
