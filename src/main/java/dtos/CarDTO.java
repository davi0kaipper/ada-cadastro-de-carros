package dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;

import api.requests.CarRequestValidator;

@JsonInclude
public record CarDTO(
    String brand,
    String model,
    String color,
    String transmission,
    Integer year,
    BigDecimal price
) {
    public static CarDTO fromCarRequestValidator(CarRequestValidator car) {
        return new CarDTO(
            car.brand,
            car.model,
            car.color,
            car.transmission,
            car.year,
            car.price
        );
    }
}
