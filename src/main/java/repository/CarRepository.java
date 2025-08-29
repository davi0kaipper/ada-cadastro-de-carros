package repository;

import java.math.BigDecimal;
import java.util.Optional;

import dtos.CarDTO;
import enums.CarType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import models.Car;

@ApplicationScoped
public class CarRepository implements PanacheRepository<Car> {
    public Optional<Car> findByModelYearPriceColor(
        String model,
        int carYear,
        BigDecimal price,
        String color
    ){
        return find(
            "model = :model and carYear = :carYear and price = :price and color = :color",
            Parameters.with("model", model)
                .and("carYear", carYear)
                .and("price", price)
                .and("color", color)
        ).firstResultOptional();
    }

    public Car createFromDto(CarDTO carDTO) {
        var car = new Car();
        car.brand = carDTO.brand();
        car.model = carDTO.model();
        car.color = carDTO.color();
        car.transmission = carDTO.transmission().transform(CarType::fromString);
        car.carYear = carDTO.year();
        car.price = carDTO.price();
        persist(car);
        return car;
    }

    public void update(Long id, CarDTO carDTO) {
        var car = findById(id);
        car.brand = this.nullSafeUpdate(car.brand, carDTO.brand());
        car.model = this.nullSafeUpdate(car.model, carDTO.model());
        car.color = this.nullSafeUpdate(car.color, carDTO.color());
        car.transmission = this.nullSafeUpdate(
            car.transmission,
            carDTO.transmission().transform(CarType::fromString)
        );
        car.carYear = this.nullSafeUpdate(car.carYear, carDTO.year());
        car.price = this.nullSafeUpdate(car.price, carDTO.price());
        persist(car);
    }

    private <T> T nullSafeUpdate(T currentValue, T newValue) {
        return newValue != null ? newValue : currentValue;
    }
}

