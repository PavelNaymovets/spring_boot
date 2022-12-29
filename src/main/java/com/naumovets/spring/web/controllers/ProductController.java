package com.naumovets.spring.web.controllers;

import com.naumovets.spring.web.model.Product;
import com.naumovets.spring.web.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/changeQuantity")
    public void changeQuantity(@RequestParam(name = "id") Long studentId, @RequestParam Integer quantity) {
        productService.setQuantity(studentId, quantity);
    }

}
