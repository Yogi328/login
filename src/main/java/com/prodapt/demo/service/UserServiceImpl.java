package com.prodapt.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prodapt.demo.entity.User;

import com.prodapt.demo.exceptions.InvalidCredentialsException;
import com.prodapt.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User getUserByName(String userName) {
		return userRepo.findByUserName(userName);

	}

	@Override
	public User updateUser(User user) {
		if (userRepo.existsById(user.getUserId())) {
			userRepo.save(user);
		}
		return user;
	}
	


	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);
		

	}

	@Override
	public User loginUser(User user) throws InvalidCredentialsException {
		User usr = userRepo.findByUserName(user.getUserName());
		if (usr != null) {
			if (usr.getPassword().equals(user.getPassword())) {

				return usr;
			} else {
				throw new InvalidCredentialsException();
			}
		} else {
			throw new InvalidCredentialsException();
		}

	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return (List<User>) userRepo.findAll();
	}

	@Override
    public User getUserById(long id) {
                 Optional<User> optional= userRepo.findById(id);
                 User user;
                 if(optional.isPresent()) {
                               user=optional.get();
                 }
                 else {
                               throw new RuntimeException("User not found for id ::"+id);
                 }
                 return user;
    
    }

	@Override
	public Optional<User> findById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}
	

}