package com.learn.selfstudy;

import com.learn.selfstudy.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private ProductDao productDao;

    @Autowired
    public CalculatorService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public double getPriceForShipment(Product product, int numberOfZones, int weightInGrams) {
        return product.getBasePrice() + (product.getPricePerKg() * weightInGrams / 1000d) + (product.getPricePerZone() * numberOfZones);
    }

    public double getPriceForLocalShipment(Product product, int weightInGrams) {
        return product.getBasePrice() + (product.getPricePerKg() * weightInGrams / 1000d) + product.getPricePerZone();
    }

    public Product getProduct(String productId) {
        return productDao.getProduct(productId);
    }

}