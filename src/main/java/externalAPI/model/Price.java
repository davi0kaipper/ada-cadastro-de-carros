package externalAPI.model;

import java.util.List;

public class Price {

    private String brand;
    private String codeFipe;
    private String fuel;
    private String fuelAcronym;
    private String model;
    private int modelYear;
    private String price;
    private List<PriceHistory> priceHistory;
    private String referenceMonth;
    private int vehicleType;

    public Price() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCodeFipe() {
        return codeFipe;
    }

    public void setCodeFipe(String codeFipe) {
        this.codeFipe = codeFipe;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuelAcronym() {
        return fuelAcronym;
    }

    public void setFuelAcronym(String fuelAcronym) {
        this.fuelAcronym = fuelAcronym;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<PriceHistory> getPriceHistory() {
        return priceHistory;
    }

    public void setPriceHistory(List<PriceHistory> priceHistory) {
        this.priceHistory = priceHistory;
    }

    public String getReferenceMonth() {
        return referenceMonth;
    }

    public void setReferenceMonth(String referenceMonth) {
        this.referenceMonth = referenceMonth;
    }

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

}