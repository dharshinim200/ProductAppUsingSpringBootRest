package com.cts.service;

import java.util.List;

import com.cts.exceptions.ProductNotFound;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.model.Product;

public interface ProductService {//extends JpaRepository<Product,Integer>{ // product--> Entity name , Integer--> datatype of priamry key

	public abstract String saveProduct(Product product);

	public abstract Product updateProduct(Product product);

	public abstract String removeProduct(int productId);

	public abstract Product getProduct(int productId) throws ProductNotFound;

	public abstract List<Product> getAllProducts();
	
	public abstract List<Product> getAllProductsBetween(int intialPrice, int finalPrice);

	public abstract List<Product> getAllProductsByCategory(String category);
	
	public abstract List<Product> getAllProductsAbove(int intialPrice);

//	public abstract List<Product> findByProductPriceBetween(int intialPrice, int finalPrice);
//
//	public abstract List<Product> findByProductCategory(String category);
//	
//	public abstract List<Product> findByProductPriceGreaterThan(int intialPrice);

}
