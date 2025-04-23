package com.cts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.exceptions.ProductNotFound;
import com.cts.model.Product;
import com.cts.service.ProductService;

@RestController // combination of controller and response body

@RequestMapping("/products") // It is older version // http://localhost:8080/products , requestmapping ->
								// define a url ethier method or class level
public class ProductController {

	@Autowired
	ProductService service;

	@GetMapping("/getMsg") // http://localhost:8080/products/getMsg , by default get method , advance
	public String sayHello() {
		return "try to listen ";
	}

	@GetMapping("/getproduct/{pid}") 
	public Product fetchProduct(@PathVariable("pid") int productId) throws ProductNotFound {
		return service.getProduct(productId);
	}
	
	@GetMapping("/getallproduct") 
	public List<Product> fetchAllProduct() {
		return service.getAllProducts();
	}
	
	@GetMapping("/getbetweenproduct/{pid}/{ped}") 
	public List<Product> fetchBetweenProduct(@PathVariable("pid") int productId , @PathVariable("ped") int producted) {
		return service.getAllProductsBetween(productId,producted);
	}
	
	@GetMapping("/getaboveproduct/{pid}") 
	public List<Product> fetchAboveProduct(@PathVariable("pid") int productId) {
		return service.getAllProductsAbove(productId);
	}
	
	@GetMapping("/getcategory/{cat}")
	public List<Product> fetchAboveProduct(@PathVariable("cat") String productCategory) {
		return service.getAllProductsByCategory(productCategory);
	}

	@PostMapping("/saveproduct")
	public String insertProduct(@RequestBody @Validated Product product) {
		return service.saveProduct(product);
	}

	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/deleteproduct/{pid}")
	public String deleteProduct(@PathVariable("pid") int productId) {
		return service.removeProduct(productId);
	}
	
}
