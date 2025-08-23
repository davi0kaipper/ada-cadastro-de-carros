package dto.mapper;

import dto.CarDTO;
import model.Car;

public class CarMapper {

    public static Car toEntity(CarDTO carDTO) {
        Car car = new Car();
        car.setBrand(carDTO.brand());
        car.setModel(carDTO.model());
        car.setYear(carDTO.carYear());
        car.setColor(carDTO.color());
        car.setTransmission(carDTO.transmission());
        car.setPrice(carDTO.price());
        return car;
    }

    public static CarDTO toDTO(Car car) {
        return new CarDTO(car.getBrand(),
                          car.getModel(),
                          car.getColor(),
                          car.getTransmission(),
                          car.getYear(),
                          car.getPrice()
                         );
    }
}
