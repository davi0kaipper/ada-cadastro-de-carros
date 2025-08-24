package externalAPI;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
@RegisterRestClient(baseUri="https://fipe.parallelum.com.br/api/v2/cars/brands/59/models/5940/years/2014-3")
public interface FipeAPIInterfaceClient {
    @GET
    String getFipe();
}
