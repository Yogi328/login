package com.prodapt.demo.service;

import java.util.List;

import com.prodapt.demo.entity.UserDetails;


	public interface UserDetailsService {// Create
		public UserDetails addUser(UserDetails userDetails);

		// Retrieve
		public UserDetails getUserById(Long id);

		// Update
		public UserDetails updateUser(UserDetails userDetails);

		// Delete
		public void deleteUserById(Long id);

		// retrieve
		public List<UserDetails> getList();
	}
