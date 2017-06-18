package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.VarnavilConstants;
import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/adm")
public class AdminController implements VarnavilConstants {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String product(ProductDto productDto, @RequestParam("files") MultipartFile[] files) throws Exception {
		productService.save(productDto, files);
		return SUCCESS;
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ProductDto product(@PathVariable("id") Integer productId) throws Exception {
		return productService.get(productId);
	}

	@RequestMapping(value = "/all/{page}", method = RequestMethod.GET)
	public List<ProductDto> products(@PathVariable("page") Integer page) throws Exception {
		return productService.getAll(page);
	}
}
