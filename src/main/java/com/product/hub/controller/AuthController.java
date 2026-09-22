package com.product.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.hub.dtos.request.LoginRequest;
import com.product.hub.service.AuthService;

@RequestMapping("/api-auth")
@RestController


public class AuthController {

	@Autowired
	private AuthService auth;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request){
		
		
		System.out.println(request);
		 return ResponseEntity.ok(auth.login(request));
		
	}
	
	
	
	
}
