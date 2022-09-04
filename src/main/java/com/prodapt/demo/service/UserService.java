package com.prodapt.demo.service;

import java.util.List;
import java.util.Optional;

import com.prodapt.demo.entity.User;
import com.prodapt.demo.exceptions.InvalidCredentialsException;

public interface UserService {
	// Create
	public User addUser(User user);

	// Retrieve
	public User getUserByName(String userName);

	// Update
	public User updateUser(User user);

	// Delete
	public void deleteUserById(Long id);// Login
	
	

	//login
	public User loginUser(User user) throws InvalidCredentialsException;
	
	//retrieve
	public List<User> getList();

	public User getUserById(long id);
	
	Optional<User> findById(long id);

}