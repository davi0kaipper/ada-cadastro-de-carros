package externalAPI;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@RegisterRestClient
public class FipeAPI {

    @Inject
    @RestClient
    FipeAPIInterfaceClient fipeRestClient;

    public String chamarFipe() {
        return fipeRestClient.getFipe();
    }
}