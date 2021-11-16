package com.buyukli.ivan.productappangular.servicies;

import com.buyukli.ivan.productappangular.model.Product;
import com.buyukli.ivan.productappangular.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return Collections.unmodifiableList(productRepository.findAllProducts());
    }

    public Product getProductById(Long id) {
        return productRepository.findProductById(id);
    }

    public void deleteProductById(Long id) {
        productRepository.getProducts().removeIf(product -> product.getId().equals(id));
    }

    public void addProduct(Product product) {
        productRepository.getProducts().add(product);
    }

    public void changeCost(Long productId, Integer delta) {
        Product product = productRepository.findProductById(productId);
        product.setCost(product.getCost() + delta);
    }
}
