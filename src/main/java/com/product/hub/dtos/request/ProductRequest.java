package com.product.hub.dtos.request;

import com.product.hub.enums.Category;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductRequest {

	private String productName;
	
	private String productDesc;
	
	private String image;
	
	private Double price;
	
	private Double discount;
	
	@Enumerated(EnumType.STRING)

	private Category category;

	
	private Integer quantity;
}
