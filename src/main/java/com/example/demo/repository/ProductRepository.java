package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	
	@EntityGraph(attributePaths={"productImages"})
	List<Product> findAll();
	
	@EntityGraph(attributePaths={"productImages"})
	Page<Product> findAll(Pageable pageable);

}
