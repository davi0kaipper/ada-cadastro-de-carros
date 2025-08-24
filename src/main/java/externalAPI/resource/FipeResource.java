package externalAPI;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/fipe")
public class FipeResource {

    @Inject
    FipeAPI fipeAPI;

    @GET
    public String consultarFipe() {
        return fipeAPI.chamarFipe();
    }
}