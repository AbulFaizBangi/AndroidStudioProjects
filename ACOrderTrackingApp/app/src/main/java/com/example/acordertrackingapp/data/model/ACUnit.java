package com.example.acordertrackingapp.data.model;

public class ACUnit {
    private String companyName;
    private String modelName;
    private int tonnage;
    private int stockCount;

    // Constructor, getters, and setters
    public ACUnit(String companyName, String modelName, int tonnage, int stockCount) {
        this.companyName = companyName;
        this.modelName = modelName;
        this.tonnage = tonnage;
        this.stockCount = stockCount;
    }

    // Getters and setters
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }
}
