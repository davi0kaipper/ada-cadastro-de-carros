package externalAPI.controller;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jboss.resteasy.reactive.RestPath;

import externalAPI.service.FipeService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Schema(hidden = true)
@Path("/fipe")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FipeController {

    private final FipeService fipeService;

    public FipeController(FipeService fipeService) {
        this.fipeService = fipeService;
    }

    @GET
    @Path("/{vehicleType}/brands")
    public Response getBrands(@RestPath String vehicleType){
        List brands = List.of(fipeService.getBrands(vehicleType));
        return Response.status(Response.Status.OK)
                .entity(brands)
                .build();
    }

    @GET
    @Path("/{vehicleType}/brands/{brandId}/models")
    public Response getAllModels(@RestPath String vehicleType, @RestPath int brandId){
        List models = List.of(fipeService.getModels(vehicleType, brandId));
        return Response.status(Response.Status.OK)
                .entity(models)
                .build();
    }

    @GET
    @Path("/{vehicleType}/brands/{brandId}/models/{modelId}/years")
    public Response getAllYears(@RestPath String vehicleType, @RestPath int brandId, @RestPath int modelId){
        List years = List.of(fipeService.getYears(vehicleType, brandId, modelId));
        return Response.status(Response.Status.OK)
                .entity(years)
                .build();
    }

    @GET
    @Path("/{vehicleType}/brands/{brandId}/models/{modelId}/years/{yearId}")
    public Response getPrice(@RestPath String vehicleType, @RestPath int brandId, @RestPath int modelId, @RestPath String yearId){
        List price = List.of(fipeService.getPrice(vehicleType, brandId, modelId, yearId));
        return Response.status(Response.Status.OK)
                .entity(price)
                .build();
    }
}
