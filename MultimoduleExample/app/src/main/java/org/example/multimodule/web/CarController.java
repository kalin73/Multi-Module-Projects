package org.example.multimodule.web;

import lombok.RequiredArgsConstructor;
import org.example.multimodule.model.car.CarDto;
import org.example.multimodule.service.CarService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;

    @PostMapping("/addCar")
    public String addCar(@RequestBody CarDto carDto) {
        return this.carService.addCar(carDto);
    }
}
