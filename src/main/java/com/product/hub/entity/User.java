package com.product.hub.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.product.hub.enums.Roles;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(unique = true)
	private String userName;
	
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	private String mobile;
	
	private String email;

	private String password;
	
	
	//metadata
	
	@Version
	private Integer version ;
	
	@CreationTimestamp
	@Column(updatable = false, insertable = true)
	private LocalDateTime createdAt;
	
	
	@UpdateTimestamp
	@Column(updatable = true, insertable = false)
	private LocalDateTime updatedAt;
	
	
	
	
}
