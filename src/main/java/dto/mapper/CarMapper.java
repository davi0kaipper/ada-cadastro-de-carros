package dto.mapper;

import dto.CarDTO;
import model.Car;

public class CarMapper {

    public static Car toEntity(CarDTO carDTO) {
        if (carDTO == null) {
            return null;
        }
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getAno());
        car.setColor(carDTO.getColor());
        car.setTransmission(carDTO.getTransmission());
        car.setPrice(carDTO.getPrice());
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
        CarDTO carDTO = new CarDTO();
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setAno(car.getAno());
        carDTO.setColor(car.getColor());
        carDTO.setTransmission(car.getTransmission());
        carDTO.setPrice(car.getPrice());
        return carDTO;
    }
}
