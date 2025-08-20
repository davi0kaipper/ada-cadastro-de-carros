package dto.mapper;

import dto.CarDTO;
import model.Car;

public class CarMapper {

    public static Car toEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.getBrand());
        car.setModel(carDTO.getModel());
        car.setYear(carDTO.getAno());
        car.setColor(carDTO.getColor());
        car.setTransmission(carDTO.getTransmission());
        car.setPrice(carDTO.getPrice());
        return car;
    }
}
