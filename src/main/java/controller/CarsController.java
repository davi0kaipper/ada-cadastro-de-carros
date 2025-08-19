package controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Car;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Path("/cars")
public class CarsController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Car> getCars () {
        List<Car> cars = new ArrayList<>();
        cars.add(
                new Car(
                        "Fiat",
                        "Uno",
                        "Prata",
                        "Manual",
                        1990,
                        new BigDecimal("20000.00")
                )
        );
        return cars;
    }
}
