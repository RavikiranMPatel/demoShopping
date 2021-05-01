package com.shoppingfactory.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingfactory.entity.User;
import com.shoppingfactory.repository.UserRepositroy;

@Service
public class UserService {
	
	@Autowired
	UserRepositroy userRepositroy;
	
	public User saveUser(User user) throws Exception{
		return userRepositroy.save(user);
	}
	
	public List<User> getUsers() throws Exception{
		return userRepositroy.findAll();
	}
	
	public User getUsersById(Long id) throws Exception{
		return userRepositroy.findById(id).orElse(null);
	}
	
	public String deleteUser(Long id) throws Exception{
		userRepositroy.deleteById(id);
		return "User Deleted Succesfully" + id;
	}
	
	public User updateUser(User user) throws Exception{
		User existingUser =  userRepositroy.findById(user.getId()).orElse(null);
		existingUser.setName(user.getName()); 
		existingUser.setPassword(user.getPassword());
		existingUser.setPhoneNumber(user.getPhoneNumber());
		existingUser.setEmailId(user.getEmailId());
		existingUser.setActive(user.isActive());
		existingUser.setState(user.getState());
		return userRepositroy.save(existingUser);
	}
	
}
