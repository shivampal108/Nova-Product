package com.product.hub.apiresponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

	
	private Integer StatusCode;
	
	private Boolean isSuccess;
	
	private LocalDateTime time;
	
	private String message;
	
	
	
	
}
