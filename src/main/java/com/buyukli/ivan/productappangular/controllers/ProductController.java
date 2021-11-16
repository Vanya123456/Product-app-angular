package com.buyukli.ivan.productappangular.controllers;

import com.buyukli.ivan.productappangular.model.Product;
import com.buyukli.ivan.productappangular.servicies.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Getter
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductInfo(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @GetMapping("/product/change_cost")
    public void change_cost(@RequestParam Long productId, @RequestParam Integer delta) {
        productService.changeCost(productId, delta);
    }

    @GetMapping("/product/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @GetMapping("/product/add/{id}")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
}
