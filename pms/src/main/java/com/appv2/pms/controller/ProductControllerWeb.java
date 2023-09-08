package com.appv2.pms.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.appv2.pms.entity.Product;
import com.appv2.pms.service.ProductService;

@Controller	
@RequestMapping("/products")
public class ProductControllerWeb {

	@Autowired
	private ProductService productService;
	
	private Product productSelected;
	private ArrayList<Product> products;
	private boolean updateFlag = false;  // update if true
	
	public ProductControllerWeb(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/products")
	@ResponseBody
	public String getAllProducts(Model theModel) {
		products = productService.getAllProducts();
		theModel.addAttribute("products", products);
		return "products";
	}
	
	@GetMapping("/addProductForm")
	public String addProductForm(Model theModel) {
		updateFlag = false;
		Product newProduct = new Product();
		theModel.addAttribute("product-form", newProduct);
		theModel.addAttribute("form-type", "Add Product");
		productSelected = newProduct;
		return "product-form";
	}
	
	@GetMapping("/updateProductForm/{productId}")
	public String updateProductForm(@RequestParam("productId") int productId, Model theModel) {
		updateFlag = true;
		productSelected = productService.findById(productId);
		theModel.addAttribute("product-form", productSelected);
		theModel.addAttribute("form-type", "Update Product");
		return "product-form";
	}
	
	@PostMapping("/saveProduct")
	public String saveProduct(@ModelAttribute("product") Product theProduct, Model theModel) {
		theProduct.setProductId(productSelected.getProductId());
		if (updateFlag) {
			theProduct.setProductId(productSelected.getProductId());
			productService.update(theProduct.getProductId(), theProduct);
		} else {
			productService.add(theProduct);
		}
		return "redirect:/products";
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@RequestParam("productId") int productId, Model theModel) {
		productService.delete(productId);
		return "redirect:/products";
	}
	
}
