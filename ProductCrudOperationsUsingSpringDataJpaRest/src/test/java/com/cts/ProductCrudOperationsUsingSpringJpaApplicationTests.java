package com.cts;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
import com.cts.repository.ProductRepository;
import com.cts.service.ProductServiceImpl;

@SpringBootTest
class ProductCrudOperationsUsingSpringJpaApplicationTests {

	@Mock
	ProductRepository repository;
	@InjectMocks
	ProductServiceImpl service;

	@Test
	void productServiceTest() {
		Product product = new Product("apple", 10000, "good", 2);
		Mockito.when(repository.save(product)).thenReturn(product);
		//String respone = service.save(Product);
		// assertEquals("Product saved successfully", respone);
	}

}
