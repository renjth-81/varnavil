package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage,Integer>{
	
	@Modifying
	@Transactional
	long deleteByProductProductIdAndProductImageIdNotIn(int productId, List<Integer> prodImgIds);	
	
	@Modifying
	@Transactional
	long deleteByProductProductId(int productId);
}
