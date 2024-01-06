package com.example.apigateway.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    private final RestTemplate restTemplate;

    public Controller(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/addCar")
    public String addCar(@RequestBody Object carDto) {
        String url = "http://localhost:8080/api/v1/car/addCar";

        return restTemplate.postForObject(url, carDto, String.class);
    }
}
