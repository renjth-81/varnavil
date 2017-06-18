package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
	
	@Id
	@GeneratedValue
	int customerId;
	
	// this can be emailid or facebook login
	String username;
	
	// nullable password because user can login with facebook
	String password;
	
	// 1 -active, 0 - inactive
	Integer isActive;
	
	// sent when user signs up email id.
	String verifyToken;

}
