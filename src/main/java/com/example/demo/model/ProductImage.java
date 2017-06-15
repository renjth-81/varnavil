package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productImage")
public class ProductImage {
	
	@Id
	@GeneratedValue
	private Integer productImageId;
	
	@JoinColumn(name="productId")
	@ManyToOne
	private Product product;
	
	private String imgPath;
	
	// 1 - small, 2 - medium, 3 - large
	private Integer imageSize;
	
	public Integer getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(Integer productImageId) {
		this.productImageId = productImageId;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public Integer getImageSize() {
		return imageSize;
	}
	public void setImageSize(Integer imageSize) {
		this.imageSize = imageSize;
	}
}
