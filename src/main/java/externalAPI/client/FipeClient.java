package externalAPI.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import externalAPI.model.Brand;
import externalAPI.model.Model;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api/v2")
@RegisterRestClient(configKey = "fipe-api")
public interface FipeClient {

    @GET
    @Path("/cars/brands")
    Brand[] getBrands();

    @GET
    @Path("/cars/brands/{brandId}/models")
    Model[] getModels(@PathParam("brandId") int brandId);
}
