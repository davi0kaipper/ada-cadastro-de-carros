package model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brand;
    private String model;
    private String color;
    private String transmission;
    private int carYear;
    private BigDecimal price;

    public Car(String brand,
               String model,
               String color,
               String transmission,
               int carYear,
               BigDecimal price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.transmission = transmission;
        this.carYear = carYear;
        this.price = price;
    }
    public Car() {}

    public int getId() { return id;}

    public void setId(int id) { this.id = id; }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return carYear;
    }

    public void setYear(int carYear) {
        this.carYear = carYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
