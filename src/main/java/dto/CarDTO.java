package dto;

import java.math.BigDecimal;

public record CarDTO(
    String brand,
    String model,
    String color,
    String transmission,
    int carYear,
    BigDecimal price
) {}
