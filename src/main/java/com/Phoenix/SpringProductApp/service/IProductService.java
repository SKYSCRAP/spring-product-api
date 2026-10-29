package com.Phoenix.SpringProductApp.service;

import com.Phoenix.SpringProductApp.model.Product;

import java.util.List;


public interface IProductService {

    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product productDetails);

    String deleteProduct(Long id);
}
