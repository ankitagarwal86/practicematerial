package com.learn.selfstudy;

import com.learn.selfstudy.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDao {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insert;

    @Autowired
    public ProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("product");
    }

    public Product getProduct(String productName) {
        return jdbcTemplate.queryForObject("SELECT * FROM product WHERE id = '" + productName + "'", (rs, rowNum) -> {
            Product product = new Product(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getInt("basePrice"),
                    rs.getDouble("pricePerKg"),
                    rs.getDouble("pricePerZone"),
                    rs.getInt("maxWeightInGrams")
            );
            return product;
        });
    }

    public List<Product> getProducts() {
        //TODO get a list of products from the database
        return null;
    }

    public void insertProduct(Product product) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", product.getId());
        parameters.put("name", product.getName());
        parameters.put("basePrice", product.getBasePrice());
        parameters.put("pricePerKg", product.getPricePerKg());
        parameters.put("pricePerZone", product.getPricePerZone());
        parameters.put("maxWeightInGrams", product.getMaxWeightInGrams());

        insert.execute(parameters);
    }

    public void deleteProduct(String productId) {
        //TODO delete product from database
    }

}
