package com.raj.springweb;

import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.raj.springweb.entities.Product;
import com.raj.springweb.repos.ProductRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(excludeAutoConfiguration = { SecurityAutoConfiguration.class })
class ProductRestControllerMvcTest {

	private static final String PRODUCTS_URL = "/productapi/products/";

	private static final String CONTEXT_URL = "/productapi";

	private static final int PRODUCT_PRICE = 15;

	private static final String PRODUCT_DESCRIPTION_STRING = "Sports Accessory";

	private static final String PRODUCT_NAME_STRING = "Waterbottle";

	private static final int PRODUCT_ID = 1;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductRepository repository;

	@Test
	void testFindAll() throws Exception {
		Product product = buildProduct();
		List<Product> products = Arrays.asList(product);
		when(repository.findAll()).thenReturn(products);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		mockMvc.perform(get(PRODUCTS_URL).contextPath(CONTEXT_URL)).andExpect(status().isOk())
				.andExpect(content().json(objectWriter.writeValueAsString(products)));
	}

	@Test
	public void testCreateProduct() throws JsonProcessingException, Exception {
		Product product = buildProduct();
		when(repository.save(any())).thenReturn(product);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		mockMvc.perform(post(PRODUCTS_URL).contextPath(CONTEXT_URL).contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product))).andExpect(status().isOk())
				.andExpect(content().json(objectWriter.writeValueAsString(product)));
	}

	@Test
	public void testUpdateProduct() throws JsonProcessingException, Exception {
		Product product = buildProduct();
		product.setPrice(44);
		when(repository.save(any())).thenReturn(product);
		ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

		mockMvc.perform(put(PRODUCTS_URL).contextPath(CONTEXT_URL).contentType(MediaType.APPLICATION_JSON)
				.content(objectWriter.writeValueAsString(product))).andExpect(status().isOk())
				.andExpect(content().json(objectWriter.writeValueAsString(product)));
	}

	@Test
	public void deleteProduct() throws Exception {
		doNothing().when(repository).deleteById(PRODUCT_ID);
		mockMvc.perform(delete(PRODUCTS_URL + PRODUCT_ID).contextPath(CONTEXT_URL)).andExpect(status().isOk());
	}

	private Product buildProduct() {
		Product product = new Product();
		product.setId(PRODUCT_ID);
		product.setName(PRODUCT_NAME_STRING);
		product.setDescription(PRODUCT_DESCRIPTION_STRING);
		product.setPrice(PRODUCT_PRICE);
		return product;
	}

}
