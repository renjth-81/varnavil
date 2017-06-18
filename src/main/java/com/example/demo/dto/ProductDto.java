package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDto {
	private Integer productId;
	private String name;
	private String description;
	private Integer price;
	private Integer stock;
	private List<Integer> productImgIds = new ArrayList<>();
	private List<ProductImageDto> prodImgDtos = new ArrayList<>();
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public List<Integer> getProductImgIds() {
		return productImgIds;
	}
	public void setProductImgIds(List<Integer> productImgIds) {
		this.productImgIds = productImgIds;
	}
	public List<ProductImageDto> getProdImgDtos() {
		return prodImgDtos;
	}
	public void setProdImgDtos(List<ProductImageDto> prodImgDtos) {
		this.prodImgDtos = prodImgDtos;
	}
}
