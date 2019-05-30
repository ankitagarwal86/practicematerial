package com.learn.selfstudy.web;

import com.learn.selfstudy.CalculatorService;
import com.learn.selfstudy.ShipmentValidator;
import com.learn.selfstudy.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class CalculatorControllerTest {

    private CalculatorController controller;
    private ExtendedModelMap model;

    @Mock private CalculatorService calculatorServiceMock;
    @Mock private ShipmentValidator shipmentValidator;

    private final double expectedPrice = 123d;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(calculatorServiceMock.getPriceForShipment(any(Product.class), anyInt(), anyInt())).thenReturn(expectedPrice);
        when(shipmentValidator.validate(any(Product.class), anyInt(), anyInt())).thenReturn(new ArrayList<>());
        model = new ExtendedModelMap();
        controller = new CalculatorController(calculatorServiceMock, shipmentValidator);
    }

    @Test
    public void should_get_calculator_view() throws Exception {
        String view = controller.get(model);
        assertThat(view).isEqualTo("calculate");
    }

    @Test
    public void should_set_input_attributes_and_view() throws Exception {
        String view = controller.post("SOME_PRODUCT", 3456, 4, model);
        assertThat(model.get("productId")).isEqualTo("SOME_PRODUCT");
        assertThat(model.get("weightInGrams")).isEqualTo(3456);
        assertThat(model.get("numberOfZones")).isEqualTo(4);
        assertThat(view).isEqualTo("calculate");
    }

    @Test
    public void should_set_price() throws Exception {
        String view = controller.post("SOME_PRODUCT", 3456, 4, model);
        assertThat(model.get("price")).isEqualTo(expectedPrice);
        assertThat(view).isEqualTo("calculate");
    }

}
