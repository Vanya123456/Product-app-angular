package com.buyukli.ivan.productappangular.repositories;

import com.buyukli.ivan.productappangular.model.Product;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    @Getter
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>(List.of(
                new Product(1L, "Bread", "0.89 Euro"),
                new Product(2L, "Milk", "0.80 Euro"),
                new Product(3L, "Tomato", "1.23 Euro"),
                new Product(4L, "Carrot", "0.95 Euro"),
                new Product(5L, "Watter", "0.23 Euro")
        ));
    }

    public List<Product> findAllProducts(){
        return products;
    }

    public  Product findProductById(Long id){
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}
