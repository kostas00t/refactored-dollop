package com.appv2.pms.service;

import com.appv2.pms.model.Product;
import com.appv2.pms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public ResponseEntity<Product> getProductById(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("No product with id:" + productId + " exists."));
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<Product> updateProduct(int productId, Product product) {
        Product updateProduct = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("No product with id:" + productId + " exists."));
        
        // If the update request doesn't have a name/description/price, don't update the existing value
        if (!(product.getName() == null)) {
        	updateProduct.setName(product.getName());
        }
        if (!(product.getDescription() == null)) {
        	updateProduct.setDescription(product.getDescription());
        }
        if (!(product.getPrice() == 0)) {
        	updateProduct.setPrice(product.getPrice());
        }
        productRepository.save(updateProduct);
        return ResponseEntity.ok(updateProduct);
    }

    @Override
    public ResponseEntity<HttpStatus> deleteProduct(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("No product with id:" + productId + " exists."));
        productRepository.delete(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
