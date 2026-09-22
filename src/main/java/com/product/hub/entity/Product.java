package com.product.hub.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.product.hub.enums.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
	
	
	@Id
	@GeneratedValue(generator = "gen1", strategy =GenerationType.SEQUENCE )
	@SequenceGenerator(name = "gen1",sequenceName = "p_seq",allocationSize = 1,initialValue = 2000)
	private Long productId;
	
	private String productName;
	
	private String productDesc;
	
	private String image;
	
	private Double price;
	
	private Double discount;
	
	private Double netPrice;
	
	private Integer quantity;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	//metadata
	
	
	@Version
	private Integer version;
	
	@UpdateTimestamp
	@Column(insertable =  false, updatable = true)
	private LocalDateTime updatedAt;
	
	@CreationTimestamp
	@Column(insertable =  true, updatable = false)

	private LocalDateTime createdAt;
	

}
