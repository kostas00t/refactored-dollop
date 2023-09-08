package com.appv2.pms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appv2.pms.entity.Product;
import com.appv2.pms.service.ProductService;

@RestController	
@RequestMapping("/api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.add(product);
    }
	
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		return productService.update(productId, product);
	}
	
    @PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		productService.delete(productId);
	}
	
}
