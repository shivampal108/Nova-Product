package com.product.hub.apiresponse;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuccessResponse<T> extends ApiResponse {

	
	private T data;



	public SuccessResponse(Integer StatusCode, Boolean isSuccess, LocalDateTime time, String message, T data) {
		super(StatusCode, isSuccess, time, message);
		
		this.data=data;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	
}
