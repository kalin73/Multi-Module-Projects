package com.example.customer;

public record CustomerRegistrationRequest(String firstName, String lastName, String email, String password) {
}
