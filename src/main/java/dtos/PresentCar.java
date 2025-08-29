package dtos;

import java.math.BigDecimal;

import models.Car;

public record PresentCar(
    Long id,
    String brand,
    String model,
    String color,
    String transmission,
    Integer year,
    BigDecimal price
){
    public static PresentCar from(Car car) {
        return new PresentCar(
            car.id,
            car.brand,
            car.model,
            car.color,
            car.transmission.name(),
            car.carYear,
            car.price
        );
    }
}
