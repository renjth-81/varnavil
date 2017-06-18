package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.VarnavilConstants;
import com.example.demo.dto.ProductDto;
import com.example.demo.dto.ProductImageDto;
import com.example.demo.model.Product;
import com.example.demo.model.ProductImage;
import com.example.demo.repository.ProductImageRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService implements VarnavilConstants {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductImageRepository productImageRepository;

	@Value("${imagePath}")
	String imagePath;

	@Value("${imageRelativePath}")
	String imageRelativePath;

	@Value("${pageSize}")
	String pageSize;

	SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmss");

	/**
	 * create and update product
	 * 
	 * @param productDto
	 * @param files
	 * @throws Exception
	 */
	@Transactional
	public void save(ProductDto productDto, MultipartFile[] files) throws Exception {
		Product product = convertToEntity(productDto);
		product = productRepository.save(product);
		String prodImgFolder = imagePath + product.getProductId();
		File imgFolder = new File(prodImgFolder);
		if (!imgFolder.exists()) {
			imgFolder.mkdirs();
		}
		if (productDto.getProductId() != null && productDto.getProductId() > 0) {
			List<Integer> prodImgIds = productDto.getProductImgIds();
			if (prodImgIds != null && prodImgIds.size() > 0) {
				productImageRepository.deleteByProductProductIdAndProductImageIdNotIn(productDto.getProductId(),
						prodImgIds);
			} else {
				productImageRepository.deleteByProductProductId(productDto.getProductId());
			}
		}
		if (files != null && files.length > 0) {
			int count = 0;
			for (MultipartFile f : files) {
				count++;
				try {
					String fileName = sdf.format(new Date()) + JPEG_EXT;
					Path path = Paths.get(prodImgFolder + "/" + count + fileName);
					byte[] bytes = f.getBytes();
					Files.write(path, bytes);
					ProductImage prodImg = new ProductImage();
					prodImg.setImgPath(imageRelativePath + fileName);
					prodImg.setProduct(product);
					productImageRepository.save(prodImg);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * all products
	 * @param pageNumber
	 * @return
	 */
	public List<ProductDto> getAll(int pageNumber) {
		Page<Product> productPage = productRepository.findAll(new PageRequest(pageNumber, Integer.parseInt(pageSize)));
		List<Product> products = productPage.getContent();
		List<ProductDto> dtos = new ArrayList<>();
		if (products != null) {
			for (Product p : products) {
				dtos.add(convertToDto(p));
			}
		}
		return dtos;
	}

	/**
	 * product details . returns null if product is not found
	 * 
	 * @param productId
	 * @return 
	 */
	public ProductDto get(Integer productId) {
		return convertToDto(productRepository.findOne(productId == null ? 0 : productId));
	}

	public ProductDto convertToDto(Product p) {
		
		ProductDto dto = new ProductDto();
		if (p == null)
			return dto;
		dto.setDescription(p.getDescription());
		dto.setName(p.getName());
		dto.setPrice(p.getPrice());
		dto.setProductId(p.getProductId());
		List<ProductImageDto> prodImgDtos = new ArrayList<>();
		for (ProductImage prodImg : p.getProductImages()) {
			ProductImageDto prodImgDto = new ProductImageDto();
			prodImgDto.setImgPath(prodImg.getImgPath());
			prodImgDto.setProductImageId(prodImg.getProductImageId());
			prodImgDtos.add(prodImgDto);
		}
		dto.setProdImgDtos(prodImgDtos);
		return dto;
	}

	public Product convertToEntity(ProductDto dto) {
		Product p = new Product();
		p.setDescription(dto.getDescription());
		p.setName(dto.getName());
		p.setPrice(dto.getPrice());
		p.setStock(dto.getStock());
		if (dto.getProductId() != null && dto.getProductId() > 0) {
			p.setProductId(dto.getProductId());
		}
		return p;
	}

}
