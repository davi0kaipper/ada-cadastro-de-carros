package model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonProperty("brand")
    private String brand;
    @JsonProperty("model")
    private String model;
    @JsonProperty("color")
    private String color;
    @JsonProperty("transmission")
    private String transmission;
    @JsonProperty("ano")
    private int ano;
    @JsonProperty("price")
    private BigDecimal price;

    public Car(String brand,
               String model,
               String color,
               String transmission,
               int ano,
               BigDecimal price) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.transmission = transmission;
        this.ano = ano;
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
        return ano;
    }

    public void setYear(int ano) {
        this.ano = ano;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
