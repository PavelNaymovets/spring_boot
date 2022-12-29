package com.naumovets.spring.web.services;

import com.naumovets.spring.web.model.Product;
import com.naumovets.spring.web.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.getAllProducts();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void setQuantity(Long id, Integer quantity) {
        Product product = productRepository.findById(id);
        product.setQuantity(product.getQuantity() + quantity);
    }
}
