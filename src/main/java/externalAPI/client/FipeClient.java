package externalAPI.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import externalAPI.model.Brand;
import externalAPI.model.Model;
import externalAPI.model.Price;
import externalAPI.model.Year;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/api/v2")
@RegisterRestClient(configKey = "fipe-api")
public interface FipeClient {

    @GET
    @Path("/{vehicleType}/brands")
    Brand[] getBrands(@PathParam("vehicleType") String vehicleType);

    @GET
    @Path("/{vehicleType}/brands/{brandId}/models")
    Model[] getModels(@PathParam("vehicleType") String vehicleType, @PathParam("brandId") int brandId);

    @GET
    @Path("/{vehicleType}/brands/{brandId}/models/{modelId}/years")
    Year[] getYears(@PathParam("vehicleType") String vehicleType, @PathParam("brandId") int brandId,
                    @PathParam("modelId") int modelId);

    @GET
    @Path("/{vehicleType}/brands/{brandId}/models/{modelId}/years/{yearId}")
    Price getPrice(@PathParam("vehicleType") String vehicleType, @PathParam("brandId") int brandId,
                   @PathParam("modelId") int modelId, @PathParam("yearId") String yearId);
}
