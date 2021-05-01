package com.shoppingfactory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shoppingfactory.entity.User;

public interface UserRepositroy extends JpaRepository<User, Long>{
	
}
