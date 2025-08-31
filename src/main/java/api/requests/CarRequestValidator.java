package api.requests;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import validation.ValidationGroups;

@JsonInclude
public class CarRequestValidator {
    @NotNull(message="o campo marca (brand) não pode ser nulo", groups=ValidationGroups.PostAndPut.class)
    @NotBlank(groups = ValidationGroups.PostAndPut.class)
    @Size(
        groups = ValidationGroups.PostAndPut.class,
        message="o campo marca (brand) deve estar entre 1 e 70",
        min=1,
        max=70
    )
    public String brand;

    @NotNull(message="o campo modelo (model) não pode ser nulo", groups=ValidationGroups.PostAndPut.class)
    @NotBlank(groups = ValidationGroups.PostAndPut.class)
    @Size(
        groups = ValidationGroups.PostAndPut.class,
        message="o campo modelo (model) deve estar entre 1 e 70",
        min=1,
        max=70
    )
    public String model;

    @NotNull(message="o campo cor (color) não pode ser nulo", groups=ValidationGroups.PostAndPut.class)
    @NotBlank(groups = ValidationGroups.PostAndPut.class)
    @Size(
        groups = ValidationGroups.PostAndPut.class,
        message="o campo cor (color) deve estar entre 1 e 20",
        min=1,
        max=20
    )
    public String color;

    @NotNull(message="o campo transmissão (transmission) não pode ser nulo", groups=ValidationGroups.PostAndPut.class)
    @NotBlank(groups = ValidationGroups.PostAndPut.class)
    @Pattern(regexp="MANUAL|AUTOMATICO", message="o valor do campo transmissão (transmission) deve ser 'MANUAL' ou 'AUTOMATICO'")
    public String transmission;

    @NotNull(message="o campo ano (year) não pode ser nulo", groups=ValidationGroups.PostAndPut.class)
    @Null(groups = ValidationGroups.Patch.class)
    @Range(min=1884, max=2030)
    public Integer year;
    
    @NotNull(message="o campo preço (price) não pode ser nulo", groups=ValidationGroups.PostAndPut.class)
    @DecimalMin(value="0.0", inclusive=false)
    @DecimalMax("85320000000.0")
    public BigDecimal price;
}
