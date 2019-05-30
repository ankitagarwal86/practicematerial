package com.learn.selfstudy;

import com.learn.selfstudy.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private ProductDao productDao;

    @Autowired
    public AdminService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public void insertProduct(Product product) {
        productDao.insertProduct(product);
    }

    public void deleteProduct(String productId) {
        productDao.deleteProduct(productId);
    }

}