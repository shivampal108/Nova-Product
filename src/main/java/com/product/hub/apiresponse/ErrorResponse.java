package com.product.hub.apiresponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse  extends ApiResponse{

	
	private String error;



	public ErrorResponse(Integer StatusCode, Boolean isSuccess, LocalDateTime time, String message,String error) {
		super(StatusCode, isSuccess, time, message);
	
		this.error=error;
		
	}


	
	
	
}
