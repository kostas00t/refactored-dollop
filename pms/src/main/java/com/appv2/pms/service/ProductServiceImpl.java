package com.appv2.pms.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appv2.pms.dao.ProductDAO;
import com.appv2.pms.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productRepository;
	
	public ProductServiceImpl() {}
	
	@Autowired
	public ProductServiceImpl(ProductDAO productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public Product findById(int productId) {
		return productRepository.findById(productId);
	}

	@Override
	public Product update(int productId, Product product) {
		Product existingProduct = productRepository.findById(productId);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        return productRepository.save(existingProduct);
	}
	
	@Override
	public void delete(int productId) {
		productRepository.delete(productRepository.findById(productId));
	}
	
	@Override
	public Product add(Product product) {
		return productRepository.save(product);
	}

	@Override
	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) productRepository.findAll();
	}


	
}
