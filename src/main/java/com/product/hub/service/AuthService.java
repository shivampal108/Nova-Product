package com.product.hub.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.product.hub.dtos.request.LoginRequest;
import com.product.hub.dtos.response.UserDtoResponse;
import com.product.hub.entity.User;
import com.product.hub.repository.UserRepository;


@Service
public class AuthService {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepo;
	
	public UserDtoResponse  login(LoginRequest request) {
		
		Authentication authentication=
				
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
						
						);
		
		User user= userRepo.findByUserName(authentication.getName());
		
		
		UserDtoResponse resp= new UserDtoResponse();
		
		BeanUtils.copyProperties(user, resp);
		
		return resp;
	}

}
