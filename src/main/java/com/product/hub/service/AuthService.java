package com.product.hub.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Service;

import com.product.hub.dtos.request.LoginRequest;
import com.product.hub.dtos.response.UserDtoResponse;
import com.product.hub.entity.User;
import com.product.hub.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Service
public class AuthService {
	
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepo;
	
	public UserDtoResponse login(
	        LoginRequest request,
	        HttpServletRequest httpRequest,
	        HttpServletResponse httpResponse) {
		
		Authentication authentication=
				
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
						
						);
		
		
	    SecurityContext context =
	            SecurityContextHolder.createEmptyContext();

	    context.setAuthentication(authentication);

	    SecurityContextHolder.setContext(context);

	    securityContextRepository.saveContext(
	            context,
	            httpRequest,
	            httpResponse
	    );
		
		
		User user= userRepo.findByUserName(authentication.getName());
		
		
		UserDtoResponse resp= new UserDtoResponse();
		
		BeanUtils.copyProperties(user, resp);
		
		return resp;
	}

}
