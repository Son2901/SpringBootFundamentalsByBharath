package com.bharath.springweb;

import com.bharath.springweb.entities.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class ProductrestapiApplicationTests {

	@Value("${productrestapi.services.url}")
	private String baseUrl;
	@Test
	void testgetProduct() {
		System.out.println("baseUrl : "+baseUrl);
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"/2", Product.class);
		Assertions.assertNotNull(product);
		Assertions.assertEquals("Samsung",product.getName());
	}

	@Test
	void testcreateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = new Product();
		product.setName("Vivo");
		product.setDescription("Vivo Smart 9i");
		product.setPrice(8000);
		Product posted = restTemplate.postForObject(baseUrl, product, Product.class);
		Assertions.assertNotNull(posted);
		Assertions.assertEquals("Vivo", posted.getName());
	}

	@Test
	void testUpdateProduct() {
		RestTemplate restTemplate = new RestTemplate();
		Product product = restTemplate.getForObject(baseUrl+"/2", Product.class);
		product.setDescription("Samsung Z fold");
		restTemplate.put(baseUrl,product);
		Product updatedproduct = restTemplate.getForObject(baseUrl+"/2", Product.class);

		Assertions.assertNotNull(updatedproduct);
		Assertions.assertEquals("Samsung Z fold",updatedproduct.getDescription());
	}

}
