package controller;

import dto.CarDTO;
import jakarta.transaction.Transactional;
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
import org.jboss.resteasy.reactive.RestPath;
import Service.CarService;

import java.util.List;

@Path("/cars")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarsController {

    private final CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GET
    public Response getCars () {
        List<CarDTO> cars = carService.getAll();
        return Response.status(Response.Status.OK)
                .entity(cars)
                .build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@RestPath Long id) {
        return Response.status(Response.Status.OK)
                .entity(carService.getById(id))
                .build();
    }

    @POST
    @Transactional
    public Response create(CarDTO carDTO) {
        carService.create(carDTO);
        return Response.status(Response.Status.CREATED).entity(carDTO).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@RestPath Long id, CarDTO carDTO) {
        carService.update(id, carDTO);
        return Response.status(Response.Status.OK).build();
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response updatePartial(@RestPath Long id, CarDTO carDTO) {
        carService.updatePartial(id, carDTO);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@RestPath Long id) {
        carService.delete(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
