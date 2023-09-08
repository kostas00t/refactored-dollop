package com.appv2.pms.service;

import java.util.ArrayList;

import com.appv2.pms.entity.Product;

public interface ProductService {
	
	public Product add(Product product);

	public void delete(int productId);
	
	public Product update(int productId, Product product);
	
	public Product findById(int productId);
	
	public ArrayList<Product> getAllProducts();

}
