package com.learn.selfstudy;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ShipmentValidatorTest {

    private ShipmentValidator shipmentValidator = new ShipmentValidator();

    @Test
    public void should_not_allow_weight_of_zero() throws Exception {
        //TODO implement test
        fail("Test not implemented");
    }

    @Test
    @Ignore
    public void should_not_allow_weight_of_less_than_zero() throws Exception {
        //TODO implement test
        fail("Test not implemented");
    }

    @Test
    @Ignore
    public void should_allow_weight_below_max_for_product() throws Exception {
        //TODO implement test
        fail("Test not implemented");
    }

}