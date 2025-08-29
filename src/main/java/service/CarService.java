package service;

import dto.CarDTO;
import dto.mapper.CarMapper;
import exception.CarAlreadyExistsExcepiton;
import exception.CarNotExistsException;
import jakarta.enterprise.context.ApplicationScoped;
import model.Car;
import repository.CarsRepository;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CarService {

    private final CarsRepository repository;

    public CarService(CarsRepository repository) {
        this.repository = repository;
    }

    public CarDTO getById(Long id) {
        return CarMapper.toDTO(findById(id));
    }

    public List<CarDTO> getAll() {
        return repository.findAll()
                .list().stream().map(CarMapper::toDTO).toList();
    }

    public void create(CarDTO carDTO) {
        Optional<Car> optionalCar =
                repository.findByModelYearPriceColor(carDTO.model(), carDTO.carYear(), carDTO.price(), carDTO.color());
        if (optionalCar.isPresent()) {
            throw new CarAlreadyExistsExcepiton("Car already exists");
        }
        Car car = CarMapper.toEntity(carDTO);
        repository.persist(car);
    }

    public void update(Long id, CarDTO carDTO) {
        Car car = findById(id);
        CarMapper.updateCar(carDTO, car);
    }

    public void delete(Long id) {
        Car car = findById(id);
        repository.delete(car);
    }

    public void updatePartial(Long id, CarDTO carDTO) {
        Car car = findById(id);
        if (carDTO.brand() != null) {
            car.setBrand(carDTO.brand());
        }
        if (carDTO.model() != null) {
            car.setModel(carDTO.model());
        }
        if (carDTO.carYear() != 0) {
            car.setYear(carDTO.carYear());
        }
        if (carDTO.color() != null) {
            car.setColor(carDTO.color());
        }
        if (carDTO.transmission() != null) {
            car.setTransmission(carDTO.transmission());
        }
        if (carDTO.price() != null) {
            car.setPrice(carDTO.price());
        }
    }

    private Car findById(Long id) {
        Car car = repository.findById(id);
        if (car == null) {
            throw new CarNotExistsException("Car not found");
        }
        return car;
    }
}
