package dto.mapper;

import dto.CarDTO;
import model.Car;

public class CarMapper {

    public static Car toEntity(CarDTO carDTO) {
        if (carDTO == null) {
            return null;
        }
        Car car = new Car();
        car.setBrand(carDTO.brand());
        car.setModel(carDTO.model());
        car.setYear(carDTO.carYear());
        car.setColor(carDTO.color());
        car.setTransmission(carDTO.transmission());
        car.setPrice(carDTO.price());
        return car;
    }

    public static Car updateCar(CarDTO carDTO, Car car) {
        if (carDTO == null || car == null) {
            return null;
        }
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getAno());
        car.setColor(carDTO.getColor());
        car.setTransmission(carDTO.getTransmission());
        car.setPrice(carDTO.getPrice());
        return car;
    }

    public static CarDTO toDTO(Car car) {
        if (car == null) {
            return null;
        }
        
        return new CarDTO(car.getId(),
                          car.getBrand(),
                          car.getModel(),
                          car.getColor(),
                          car.getTransmission(),
                          car.getYear(),
                          car.getPrice()
                         );
    }
}
