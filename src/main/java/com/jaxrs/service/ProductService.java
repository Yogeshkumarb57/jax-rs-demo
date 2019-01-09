package com.jaxrs.service;

import com.jaxrs.model.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(Integer id);

    List<Product> getAllProducts();

    List<Product> saveProduct(Product product);

    boolean deleteProduct(Integer id);

    List<Product> updateProduct(Product product);
}
