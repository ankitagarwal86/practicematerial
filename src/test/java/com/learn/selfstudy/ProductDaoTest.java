package com.learn.selfstudy;

import com.learn.selfstudy.config.TestConfig;
import com.learn.selfstudy.domain.Product;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@ContextConfiguration(classes = {TestConfig.class})
public class ProductDaoTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private ProductDao productDao;

    @Before
    public void setup() {
        productDao = new ProductDao(jdbcTemplate);
    }

    @Test
    public void should_get_product() throws Exception {
        Product product = productDao.getProduct("SERVICE_PACKAGE");
        assertThat(product.getId()).isEqualTo("SERVICE_PACKAGE");
    }

    @Ignore
    @Test
    public void should_get_products() throws Exception {
        //TODO implement test
        fail("Test not implemented");
    }

    @Test
    @DirtiesContext
    public void should_insert_product() throws Exception {
        Product product = new Product("TEST_PRODUCT", "name", 20, 10.2d, 5.1d, 30000);
        productDao.insertProduct(product);

        Product insertedProduct = productDao.getProduct("TEST_PRODUCT");
        assertThat(insertedProduct.getId()).isEqualTo(product.getId());
        assertThat(insertedProduct.getBasePrice()).isEqualTo(product.getBasePrice());
        assertThat(insertedProduct.getPricePerKg()).isEqualTo(product.getPricePerKg());
        assertThat(insertedProduct.getPricePerZone()).isEqualTo(product.getPricePerZone());
        assertThat(insertedProduct.getMaxWeightInGrams()).isEqualTo(product.getMaxWeightInGrams());
    }

    @Ignore
    @Test(expected = EmptyResultDataAccessException.class)
    @DirtiesContext
    public void should_delete_product() throws Exception {
        String productId = "TEST_PRODUCT";
        Product product = new Product(productId, "name", 20, 10.2d, 5.1d, 30000);
        productDao.insertProduct(product);
        productDao.deleteProduct(productId);
        productDao.getProduct(productId);
    }

}