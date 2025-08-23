package controller;

import dto.CarDTO;
import dto.mapper.CarMapper;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Car;
import repository.CarsRepository;

import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarsController {

    private final CarsRepository repository;

    public CarsController(CarsRepository repository) {
        this.repository = repository;
    }

    @GET
    public Response getCars () {
        List<Car> cars = repository.findAll().list();
        List<CarDTO> carsDTO = cars.stream().map(CarMapper::toDTO).toList();

        return Response.status(Response.Status.OK)
                .entity(carsDTO)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getCarById(@PathParam("id") Long carId) {
        Car car = repository.findById(carId);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Car not found")
                    .build();
        }

	CarDTO carDTO = CarMapper.toDTO(car);
        return Response.status(Response.Status.OK)
                .entity(car)
                .build();
    }

    @POST
    @Transactional
    public Response addCar(CarDTO carDTO) {
        repository.persist(CarMapper.toEntity(carDTO));

        return Response.status(Response.Status.CREATED).entity(carDTO).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateCar(@PathParam("id") Long carId, CarDTO carDTO) {
        Car existingCar = repository.findById(carId);
        if (existingCar == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Car not found")
                    .build();
        }
        existingCar.setBrand(carDTO.brand());
        existingCar.setModel(carDTO.model());
        existingCar.setColor(carDTO.color());
        existingCar.setTransmission(carDTO.transmission());
        existingCar.setYear(carDTO.carYear());
        existingCar.setPrice(carDTO.price());

        repository.persist(existingCar);

        return Response.status(Response.Status.OK)
                .entity(existingCar)
                .build();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response patchCar(@PathParam("id") Long carId, CarDTO carDTO) {
        Car existingCar = repository.findById(carId);
        if (existingCar == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Car not found")
                    .build();
        }
        if (carDTO.brand() != null) {
            existingCar.setBrand(carDTO.brand());
        }
        if (carDTO.model() != null) {
            existingCar.setModel(carDTO.model());
        }
        if (carDTO.color() != null) {
            existingCar.setColor(carDTO.color());
        }
        if (carDTO.transmission() != null) {
            existingCar.setTransmission(carDTO.transmission());
        }
        if (carDTO.carYear() != 0) {
            existingCar.setYear(carDTO.carYear());
        }
        if (carDTO.price() != null) {
            existingCar.setPrice(carDTO.price());
        }
        return Response.status(Response.Status.OK)
                .entity(existingCar)
                .build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCar(@PathParam("id") Long carId) {
        Car car = repository.findById(carId);
        if (car == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Car not found")
                    .build();
        }
        repository.delete(car);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
