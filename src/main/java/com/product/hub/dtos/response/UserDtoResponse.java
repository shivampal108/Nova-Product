package com.product.hub.dtos.response;

import com.product.hub.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
	
	private String userName;
	private Roles role;
	private String mobile;
	private String email;
	

}
