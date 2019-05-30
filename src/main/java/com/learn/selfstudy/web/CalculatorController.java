package com.learn.selfstudy.web;

import com.learn.selfstudy.ShipmentValidator;
import com.learn.selfstudy.domain.Product;
import com.learn.selfstudy.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/calculate")
public class CalculatorController {

    private final CalculatorService calculatorService;
    private final ShipmentValidator shipmentValidator;

    @Autowired
    public CalculatorController(CalculatorService calculatorService, ShipmentValidator shipmentValidator) {
        this.calculatorService = calculatorService;
        this.shipmentValidator = shipmentValidator;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String get(Model model) {
        model.addAttribute("productId", "SERVICE_PACKAGE");
        model.addAttribute("weightInGrams", 3500);
        model.addAttribute("numberOfZones", 1);

        return "calculate";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(
            @RequestParam("productId") String productId,
            @RequestParam("weightInGrams") int weightInGrams,
            @RequestParam("numberOfZones") int numberOfZones,
            Model model) {

        model.addAttribute("productId", productId);
        model.addAttribute("weightInGrams", weightInGrams);
        model.addAttribute("numberOfZones", numberOfZones);

        Product product = calculatorService.getProduct(productId);

        List<String> errors = shipmentValidator.validate(product, weightInGrams, numberOfZones);
        if (errors.isEmpty()) {
            double price = getPrice(product, weightInGrams, numberOfZones);
            model.addAttribute("price", price);
        }
        else {
            model.addAttribute("errorMessages", errors);
        }

        return "calculate";
    }

    private double getPrice(Product product, int weightInGrams, int numberOfZones) {
        if (numberOfZones == 0) {
            return calculatorService.getPriceForLocalShipment(product, weightInGrams);
        }
        else {
            return calculatorService.getPriceForShipment(product, numberOfZones, weightInGrams);
        }
    }
}
