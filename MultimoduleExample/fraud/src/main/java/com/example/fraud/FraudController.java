package com.example.fraud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@Slf4j
public record FraudController(FraudCheckService fraudCheckService) {
    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId) {
        boolean isFraudulentCustomer = this.fraudCheckService.isFraudulentCustomer(customerId);

        log.info("Fraud check request for customer {}", customerId);

        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
