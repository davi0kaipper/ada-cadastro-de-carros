package externalAPI.service;

import externalAPI.client.FipeClient;
import externalAPI.model.Brand;
import externalAPI.model.Price;
import externalAPI.model.Model;
import externalAPI.model.Year;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class FipeService {

    @Inject
    @RestClient
    FipeClient fipeClient;

    public Brand[] getBrands(String vehicleType) {
        return fipeClient.getBrands(vehicleType);
    }

    public Model[] getModels(String vehicleType, int brandId) {
        return fipeClient.getModels(vehicleType, brandId);
    }

    public Year[] getYears(String vehicleType, int brandId, int modelId) {
        return fipeClient.getYears(vehicleType, brandId, modelId);
    }

    public Price getPrice(String vehicleType, int brandId, int modelId, String yearId) {
        return fipeClient.getPrice(vehicleType, brandId, modelId, yearId);
    }
}