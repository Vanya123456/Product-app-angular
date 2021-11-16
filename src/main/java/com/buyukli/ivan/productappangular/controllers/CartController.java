package com.buyukli.ivan.productappangular.controllers;

import com.buyukli.ivan.productappangular.model.Cart;
import com.buyukli.ivan.productappangular.model.Product;
import com.buyukli.ivan.productappangular.servicies.ProductService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Getter
    private Cart cart;
    @Getter
    private ProductService productService;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Autowired
    public void setProductRepository(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/cart/add/{productId}")
    public void addProductInCart(@PathVariable Long productId){
        Product product = productService.getProductById(productId);
        cart.getProducts().add(product);
    }

    @GetMapping("/cart/delete/{productId}")
    public void deleteProductFromCart(@PathVariable Long productId){
        Product product = productService.getProductById(productId);
        cart.getProducts().removeIf(p -> p.getId().equals(product.getId()));
    }

    @GetMapping("/cart/show_products")
    public List<Product> showAllProducts() {
        return cart.getProducts();
    }
}
