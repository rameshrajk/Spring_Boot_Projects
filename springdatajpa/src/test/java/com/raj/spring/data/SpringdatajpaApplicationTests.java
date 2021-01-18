package com.raj.spring.data;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.raj.spring.data.entities.Product;
import com.raj.spring.data.repos.ProductRepository;

@SpringBootTest
class SpringdatajpaApplicationTests {

	@Autowired
	ApplicationContext context;
	
	@Test
	void saveProduct() {
		ProductRepository repository = context.getBean(ProductRepository.class);
		Product product = new Product();
		product.setId(1L);
		product.setName("Call of Duty");
		product.setDescription("FPS");
		product.setPrice(60d);
		/*repository.save(product);
		
		Optional<Product> productOptional = repository.findById(1L);		
		Product product1 = productOptional.get();
		System.out.println(product1);

		product1.setPrice(100d);
		repository.save(product1);
		
		repository.findAll().forEach(p->{System.out.println(p.getPrice());});*/
		
		System.out.println(repository.findByName("Call of Duty"));
		System.out.println(repository.findByPrice(100d));
		System.out.println(repository.findByNameAndPrice("Call of Duty", 100d));
	}

}
