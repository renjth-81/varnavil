package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchase")
public class Purchase {
	@Id
	@GeneratedValue
	int purchaseId;

	@ManyToOne(fetch = FetchType.EAGER)
	Product product;
	
	@ManyToOne(fetch = FetchType.EAGER)
	VOrder vOrder;

	int quantity;

	public int getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(int purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public VOrder getvOrder() {
		return vOrder;
	}

	public void setvOrder(VOrder vOrder) {
		this.vOrder = vOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
