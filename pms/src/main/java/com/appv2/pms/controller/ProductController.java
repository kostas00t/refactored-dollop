package com.appv2.pms.controller;

import com.appv2.pms.model.Product;
import com.appv2.pms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@EnableMethodSecurity
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable int productId, @RequestBody Product updatedProduct) {
        return productService.updateProduct(productId, updatedProduct);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{productId}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }

}
