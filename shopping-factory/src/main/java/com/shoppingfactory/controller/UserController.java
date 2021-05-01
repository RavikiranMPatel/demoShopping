package com.shoppingfactory.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingfactory.entity.User;
import com.shoppingfactory.service.UserService;

@RestController
public class UserController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
		try {
			userService.saveUser(user);
			return returnStatusMessage("User Created Succesfully!",user.getId(),null);
		}
		catch(Exception e) {
			LOGGER.error("Exception while creating User",e);
			return returnStatusMessage("Failed to Create User!",null,e.toString());
		}
	}

	@GetMapping("/users")
	public List<User> findAllUsers(){
		try {
			return userService.getUsers();
		} catch (Exception e) {
			LOGGER.error("Exception while fetching list of Users",e);
		}
		return null;
	}

	@GetMapping("/userById/{id}")
	public User findUserById(@PathVariable Long id) {
		try {
			return userService.getUsersById(id);
		} catch (Exception e) {
			LOGGER.error("Exception while fetching a User By Id",e);
		}
		return null;
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		try {
			return userService.updateUser(user);
		} catch (Exception e) {
			LOGGER.error("Exception while Updating a User",e);
		}
		return user;
	} 
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		try {
			userService.deleteUser(id);
			return returnStatusMessage("User Deleted Succesfully!",id,null);
		} catch (Exception e) {
			LOGGER.error("Exception while Deleting a User",e);
			return returnStatusMessage("Failed to Delete User!",id,e.getMessage());
		}
	}
	
	private String returnStatusMessage(String message, Long id, String reason) {
		StringBuilder sb = new StringBuilder();
		sb.append("Status : " + message + "\n");
		if(null!=id)
		sb.append("User Id : " + id +"\n");
		sb.append("Date : " + new Date() +"\n");
		if(null!=reason && !"".equals(reason))
		sb.append("Failure Reason:" + reason + "\n");
		return sb.toString();
	}
}
