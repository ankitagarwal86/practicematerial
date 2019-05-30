package com.learn.selfstudy;

import com.learn.selfstudy.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class CalculatorServiceTest {

    private CalculatorService calculatorService;

    @Mock
    private ProductDao productDaoMock;

    private final double pricePerKg = 5.5d;
    private final double pricePerZone = 8.3d;
    private final int basePrice = 50;
    private Product daoProduct = new Product("SERVICE_PACKAGE", "service package", basePrice, pricePerKg, pricePerZone, 30000);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(productDaoMock.getProduct(anyString())).thenReturn(daoProduct);
        calculatorService = new CalculatorService(productDaoMock);
    }

    @Test
    public void should_calculate_price_for_shipment() {
        double price = calculatorService.getPriceForShipment(daoProduct, 2, 3500);
        double expected = basePrice + (pricePerZone * 2) + (pricePerKg * 3500 / 1000);
        assertThat(price).isEqualTo(expected);

        price = calculatorService.getPriceForShipment(daoProduct, 5, 1500);
        expected = basePrice + (pricePerZone * 5) + (pricePerKg * 1500 / 1000);
        assertThat(price).isEqualTo(expected);
    }

    @Test
    public void should_calculate_price_for_local_shipment() throws Exception {
        //TODO implement
        fail("Test not implemented");
    }

}
