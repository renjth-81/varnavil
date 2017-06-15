package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderStatus")
public class OrderStatus {
	@Id
	@GeneratedValue
	int orderStatusId;

	// 1 - paid, 2 - delivered, 3 - cancelled
	String statusName;
}
