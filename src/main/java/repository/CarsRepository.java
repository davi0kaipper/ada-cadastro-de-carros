package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;
import model.Car;

import java.math.BigDecimal;
import java.util.Optional;

@ApplicationScoped
public class CarsRepository implements PanacheRepository<Car> {
    public Optional<Car> findByModelYearPriceColor(String model, int carYear, BigDecimal price, String color) {
        return find("model = :model and carYear = :carYear and price = :price and color = :color",
                Parameters.with("model", model)
                        .and("carYear", carYear)
                        .and("price", price)
                        .and("color", color)
        ).firstResultOptional();
    }
}

