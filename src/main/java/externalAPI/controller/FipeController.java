package externalAPI.controller;

import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestPath;

import externalAPI.client.FipeClient;
import jakarta.inject.Inject;
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

    private @Inject @RestClient FipeClient fipeClient;

    @GET
    @Path("/cars/brands")
    public Response getBrands(){
        var brands = fipeClient.getBrands();
        return Response.status(Response.Status.OK)
            .entity(brands)
            .build();
    }

    @GET
    @Path("/cars/brands/{brandId}/models")
    public Response getAllModels(@RestPath int brandId){
        var models = fipeClient.getModels(brandId);
        return Response.status(Response.Status.OK)
            .entity(models)
            .build();
    }
}
