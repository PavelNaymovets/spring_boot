package com.naumovets.spring.web.repositories;

import com.naumovets.spring.web.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L,"Milk", 0),
                new Product(2L,"Sugar", 0),
                new Product(3L,"Bread", 0),
                new Product(4L,"Water", 0),
                new Product(5L,"Apple", 0)
        ));
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void deleteById(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
}
