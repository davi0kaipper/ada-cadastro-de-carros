package models;

import java.math.BigDecimal;

import enums.CarType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String brand;
    public String model;
    public String color;
    @Enumerated(EnumType.STRING)
    public CarType transmission;
    public Integer carYear;
    public BigDecimal price;

    public Car() {}

    public Car(
        String brand,
        String model,
        String color,
        CarType transmission,
        Integer year,
        BigDecimal price
    ){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.transmission = transmission;
        this.carYear = year;
        this.price = price;
    }
}
