package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import model.Car;

public class CarsRepository implements PanacheRepository<Car> {}
