package com.raj.springweb;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;
import com.raj.springweb.entities.Product;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseURL;

	@Test
	void testGetProduct() {
		System.out.println(baseURL);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL + "1", Product.class);
		assertNotNull(product);
		assertEquals("iPhone", product.getName());
	}

	@Test
	void testCreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("xBox Series X");
		product.setDescription("Game Console");
		product.setPrice(700);
		Product newProduct = restTemplate.postForObject(baseURL, product, Product.class);
		assertNotNull(newProduct);
		assertNotNull(newProduct.getId());
		assertEquals("xBox Series X", newProduct.getName());
	}

	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseURL + "1", Product.class);
		product.setPrice(1099);
		restTemplate.put(baseURL, product);
	}

}
