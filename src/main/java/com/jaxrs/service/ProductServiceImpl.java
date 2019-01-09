package com.jaxrs.service;

import com.jaxrs.model.Product;

import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Named("productServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static List<Product> productList = null;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Mobile", "Mobile", BigDecimal.valueOf(9999)));
        productList.add(new Product(2, "Laptop", "Laptop", BigDecimal.valueOf(45000)));
        productList.add(new Product(3, "HDD", "HDD", BigDecimal.valueOf(5000)));
        productList.add(new Product(4, "Pendrive", "Pendrive", BigDecimal.valueOf(400)));
    }

    @Override
    public Product getProduct(Integer id) {
        boolean found = productList.stream().anyMatch(product -> product.getProductId() == id);
        return found ? productList.stream().filter(product -> product.getProductId() == id).collect(Collectors.toList()).get(0) : null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productList;
    }

    @Override
    public List<Product> saveProduct(Product product) {
        productList.add(product);
        return productList;
    }

    @Override
    public boolean deleteProduct(Integer id) {
        boolean found = productList.stream().anyMatch(product -> product.getProductId() == id);
        return found ? productList.remove(getProduct(id)) : false;
    }

    @Override
    public List<Product> updateProduct(Product product) {
        boolean found = productList.stream().anyMatch(pro -> pro.getProductId() == product.getProductId());
        if (found) {
            productList.remove(getProduct(product.getProductId()));
            productList.add(product);
        }
        return productList;
    }
}
