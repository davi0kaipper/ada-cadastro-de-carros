package controllers;

import org.jboss.resteasy.reactive.RestPath;

import api.requests.CarRequestValidator;
import dtos.CarDTO;
import dtos.PresentCar;
import exceptions.CarAlreadyExistsExcepiton;
import exceptions.CarNotExistsException;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import repository.CarRepository;
import validation.ValidationGroups;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarController {
    private @Inject CarRepository carRepository;

    @GET
    public Response getCars() {
        var cars = carRepository.findAll().stream()
            .map(PresentCar::from).toList();
        return Response.status(Response.Status.OK).entity(cars).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@RestPath Long id) {
        var carOpt = carRepository.findByIdOptional(id);
        if (carOpt.isEmpty()) {
            throw new CarNotExistsException();
        }
        return Response.status(Response.Status.OK)
            .entity(PresentCar.from(carOpt.get()))
            .build();
    }

    @POST
    @Transactional
    public Response create(
        @Valid
        @ConvertGroup(to = ValidationGroups.PostAndPut.class)
        CarRequestValidator carRequest
    ) throws CarAlreadyExistsExcepiton {
        var carDTO = CarDTO.fromCarRequestValidator(carRequest);
        var carAlreadyExists = carRepository.findSameCar(carDTO).isPresent();
        if (carAlreadyExists) {
            throw new CarAlreadyExistsExcepiton("Este carro já existe.");
        }
        var car = carRepository.createFromDto(carDTO);
        return Response.status(Response.Status.CREATED).entity(car).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(
        @RestPath Long id,
        @Valid
        @ConvertGroup(to = ValidationGroups.PostAndPut.class)
        CarRequestValidator carRequest
    ){
        var carDTO = CarDTO.fromCarRequestValidator(carRequest);
        var car = carRepository.update(id, carDTO);
        return Response.status(Response.Status.OK).entity(car).build();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response updatePartial(
        @RestPath Long id,
        @Valid
        @ConvertGroup(to = ValidationGroups.Patch.class)
        CarRequestValidator carRequest
    ){
        var carDTO = CarDTO.fromCarRequestValidator(carRequest);
        var car = carRepository.update(id, carDTO);
        return Response.status(Response.Status.OK).entity(car).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@RestPath Long id) {
        carRepository.deleteById(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
