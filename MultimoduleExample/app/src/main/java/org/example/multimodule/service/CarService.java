package org.example.multimodule.service;

import lombok.RequiredArgsConstructor;
import org.example.multimodule.model.car.Car;
import org.example.multimodule.model.car.CarDto;
import org.example.multimodule.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;

    public String addCar(CarDto carDto) {
        Car car = Car.builder()
                .brand(carDto.getBrand())
                .color(carDto.getColor())
                .build();
        this.carRepository.save(car);

        return "Added";
    }

}
