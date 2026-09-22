package com.product.hub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.hub.entity.User;
import com.product.hub.exception.UserNotFoundException;

import java.util.List;


public interface UserRepository  extends JpaRepository<User, Long>{
	
	
	
	public User  findByUserName(String userName) throws UserNotFoundException;

}
