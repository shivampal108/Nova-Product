package com.product.hub.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	
	
	@Size(min=4,max=18,message = "username must be between 4 and 8!")
	@NotBlank(message ="username  requred")
	
	private String userName;
	
	@Size(min=4,max=18,message = "password must be between 4 and 8!")

	@NotBlank
(message ="passowrd  requred")
	private String password;
	
	@Email
	
	@NotBlank(message ="email  requred")
	private String email;
	
	@Size(min = 10,max = 10, message = "mobile must be 10 digits!")

	@NotBlank(message = "mobile number requred")
	private String mobile;
	
}
