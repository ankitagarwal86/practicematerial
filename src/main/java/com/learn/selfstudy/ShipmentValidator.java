package com.learn.selfstudy;

import com.learn.selfstudy.domain.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShipmentValidator {

    public List<String> validate(Product product, int weightInGrams, int numberOfZones) {
        List<String> errors = new ArrayList<>();
        //TODO validate weight limits
        return errors;
    }

}
