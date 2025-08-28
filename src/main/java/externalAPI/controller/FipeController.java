package externalAPI.controller;

import externalAPI.service.FipeService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.List;

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
    @Path("/brands")
    public Response getAllBrands(){
        List brands = List.of(fipeService.getBrands("cars"));
        return Response.status(Response.Status.OK)
                .entity(brands)
                .build();
    }

    @GET
    @Path("/models")
    public Response getAllModels(){
        List models = List.of(fipeService.getModels("cars", 22));
        return Response.status(Response.Status.OK)
                .entity(models)
                .build();
    }

    @GET
    @Path("/years")
    public Response getAllYears(){
        List years = List.of(fipeService.getYears("cars", 22, 657));
        return Response.status(Response.Status.OK)
                .entity(years)
                .build();
    }

    @GET
    @Path("/price")
    public Response getPrice(){
        List price = List.of(fipeService.getPrice("cars", 22, 657, "1985-1"));
        return Response.status(Response.Status.OK)
                .entity(price)
                .build();
    }
}
