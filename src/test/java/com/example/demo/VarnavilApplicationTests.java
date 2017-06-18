package com.example.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Product;
import com.example.demo.model.ProductImage;
import com.example.demo.repository.ProductRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class VarnavilApplicationTests {
	
	@Autowired
	ProductRepository productRepository;

	@Test
	public void contextLoads() {
		Product p = productRepository.findOne(1);
		System.out.println(p.getName());
		List<ProductImage> productImages = p.getProductImages();
		System.out.println(productImages.get(0).getImgPath());
		
		List<Product> products = productRepository.findAll();
		assertTrue(productImages.size()>0);
	}

}
