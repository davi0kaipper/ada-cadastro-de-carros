package model;

import java.math.BigDecimal;

public class Car {

    private String brand;
    private String model;
    private String color;
    private String transmission;
    private int ano;
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

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
