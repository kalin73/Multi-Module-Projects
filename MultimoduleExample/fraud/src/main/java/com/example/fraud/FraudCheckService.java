package com.example.fraud;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record FraudCheckService(FraudCheckHistoryRepository fraudCheckHistoryRepository) {
    public boolean isFraudulentCustomer(Long customerId) {
        return this.fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .isFraudster(false)
                .customerId(customerId)
                .createdAt(LocalDateTime.now())
                .build()).isFraudster();
    }
}
