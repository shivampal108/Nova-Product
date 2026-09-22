package com.product.hub.service;

import java.util.List;

import com.product.hub.dtos.request.UserDto;
import com.product.hub.dtos.response.UserDtoResponse;

public interface UserService {
	
	public UserDtoResponse add(UserDto user);
	
	public UserDtoResponse viewUser(String userName);
	
	public UserDtoResponse updateUser(Long id, UserDto request);
	
	public String deleteUser(Long id);
	
	public List<UserDtoResponse> viewUsers();


}
