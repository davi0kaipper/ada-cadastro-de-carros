package dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CarDTO(
    @JsonProperty("brand")
    String brand,
    @JsonProperty("model")
    String model,
    @JsonProperty("color")
    String color,
    @JsonProperty("transmission")
    String transmission,
    @JsonProperty("carYear")
    int carYear,
    @JsonProperty("price")
    BigDecimal price
) {}
