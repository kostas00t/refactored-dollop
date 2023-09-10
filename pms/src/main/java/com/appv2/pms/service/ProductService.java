package com.appv2.pms.service;

import com.appv2.pms.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public Product save(Product product);
    public ResponseEntity<Product> getProductById(int productId);
    public ResponseEntity<Product> updateProduct(int productId, Product product);
    public ResponseEntity<HttpStatus> deleteProduct(int id);

}
