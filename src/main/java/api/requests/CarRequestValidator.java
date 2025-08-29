package api.requests;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import validation.ValidationGroups;

public class CarRequestValidator {
    @NotBlank(groups = ValidationGroups.PostAndPut.class)
    @Size(
        groups = ValidationGroups.PostAndPut.class,
        message="o campo brand deve ser maior ou igual a 3",
        min=3,
        max=20
    )
    @Null(groups = ValidationGroups.Patch.class)
    public String brand;

    @NotBlank(groups = ValidationGroups.PostAndPut.class)
    @Size(
        groups = ValidationGroups.PostAndPut.class,
        message="o campo model deve ser maior ou igual a 3",
        min=3,
        max=20
    )
    @Null(groups = ValidationGroups.Patch.class)
    public String model;

    @NotBlank(groups = ValidationGroups.PostAndPut.class)
    @Size(
        groups = ValidationGroups.PostAndPut.class,
        message="o campo color deve ser maior ou igual a 3",
        min=3,
        max=20
    )
    @Null(groups = ValidationGroups.Patch.class)
    public String color;

    @NotBlank(groups = ValidationGroups.PostAndPut.class)
    @Pattern(regexp="MANUAL|AUTOMATICO", message="o valor do campo transmission deve ser 'MANUAL' ou 'AUTOMATICO'")
    @Null(groups = ValidationGroups.Patch.class)
    public String transmission;

    @NotNull
    @Null(groups = ValidationGroups.Patch.class)
    @Range(min=1884, max=2030)
    public Integer year;
    
    @NotNull(message="o campo price não pode ser nulo")
    @Null(groups = ValidationGroups.Patch.class)
    @DecimalMin(value="0.0", inclusive=false)
    @DecimalMax("85320000000.0")
    public BigDecimal price;
}
