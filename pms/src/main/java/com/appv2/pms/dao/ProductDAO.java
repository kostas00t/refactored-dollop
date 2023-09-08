package com.appv2.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appv2.pms.entity.Product;

@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {
	
	public Product findById(int productId);
	/*
	@Query("select p from Product p")
	public List<Product> getAllProducts();
	
	@Modifying
	@Query("update Product p set p.productId = ?1, p.name = ?2, p.description = ?3, p.price = ?4")
	public void update(int productId, String name, String description, double price);
	
	@Modifying
	@Query("delete Product p where p.productId = ?1")
	public void delete(int productId);
	*/
}
