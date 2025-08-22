package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record CarDTO(
    @JsonProperty("brand")
    String brand,
    @JsonProperty("model")
    String model,
    @JsonProperty("color")
    String color,
    @JsonProperty("transmission")
    String transmission,
    @JsonProperty("ano")
    int ano,
    @JsonProperty("price")
    BigDecimal price
) {
    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public String getTransmission() {
        return this.transmission;
    }

    public int getYear() {
        return this.ano;
    }

    public BigDecimal getPrice() {
        return price;
    }

}
