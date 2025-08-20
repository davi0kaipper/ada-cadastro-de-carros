package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import model.Car;

@ApplicationScoped
public class CarsRepository implements PanacheRepository<Car> {}
