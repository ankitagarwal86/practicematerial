package com.learn.selfstudy.domain;

public class Product {

    private final String id;
    private final String name;
    private final int basePrice;
    private final double pricePerKg;
    private final double pricePerZone;
    private final long maxWeightInGrams;

    public Product(String id, String name, int basePrice, double pricePerKg, double pricePerZone, long maxWeightInGrams) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.pricePerKg = pricePerKg;
        this.pricePerZone = pricePerZone;
        this.maxWeightInGrams = maxWeightInGrams;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getPricePerZone() {
        return pricePerZone;
    }

    public long getMaxWeightInGrams() {
        return maxWeightInGrams;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", basePrice=" + basePrice +
                ", pricePerKg=" + pricePerKg +
                ", pricePerZone=" + pricePerZone +
                ", maxWeightInGrams=" + maxWeightInGrams +
                '}';
    }
}
