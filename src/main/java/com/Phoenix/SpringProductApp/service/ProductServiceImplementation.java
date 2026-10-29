package com.Phoenix.SpringProductApp.service;

import com.Phoenix.SpringProductApp.model.Product;
import com.Phoenix.SpringProductApp.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class ProductServiceImplementation implements IProductService {


    /*
    automatic dependency injection. It tells the Spring container to find a matching
     bean and inject it into the annotated location, so you don't have to manually
     instantiate or look up dependencies.
     */
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        log.info("getAllProducts() was hit");

        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        log.info("getProductById() was hit");

        return productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        log.info("createProduct() was hit");

        return productRepository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(Long id, Product productDetails) {
        log.info("updateProduct() was hit");

        Product existingProduct = productRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Product not found"));

        if (existingProduct.getName() != null)
            existingProduct.setName(productDetails.getName());
        if (productDetails.getDescription() != null)
            existingProduct.setDescription(productDetails.getDescription());
        if (productDetails.getPrice() != null)
            existingProduct.setPrice(productDetails.getPrice());
        if (productDetails.getQuantity() > 0)
            existingProduct.setQuantity(productDetails.getQuantity());

        return productRepository.save(existingProduct);

    }

    @Override
    public String deleteProduct(Long id) {
        log.info("deleteProduct() was hit");


        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return "Product deleted successfully";

        } else {
            throw new RuntimeException("Product dies not exist !");
        }
    }

}
