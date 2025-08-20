package controller;

import dto.CarDTO;
import dto.mapper.CarMapper;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Car;
import repository.CarsRepository;

import java.util.List;

@Path("/cars")
public class CarsController {

    private final CarsRepository repository;

    public CarsController(CarsRepository repository) {
        this.repository = repository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars () {
        List<Car> cars = repository.findAll().list();

        return Response.status(Response.Status.OK)
                .entity(cars)
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response addCar(CarDTO carDTO) {
        repository.persist(CarMapper.toEntity(carDTO));
        return Response.status(Response.Status.CREATED).entity(carDTO).build();
    }

}
