package com.product.hub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.product.hub.entity.User;
import com.product.hub.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		   User user = userRepo.findByUserName(username);
		   
		   
				return org.springframework.security.core.userdetails.User
						.withUsername(username)
						.password(user.getPassword())
						.roles(user.getRole().name())
						.build();
	               	
		
		
		
	}

}
