package com.product.hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.hub.entity.Product;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	
	public Product  findByProductName(String productName);

}
