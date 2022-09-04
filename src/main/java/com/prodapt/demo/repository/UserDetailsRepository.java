package com.prodapt.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.demo.entity.User;
import com.prodapt.demo.entity.UserDetails;

@Repository
public interface UserDetailsRepository extends CrudRepository<UserDetails, Long>{
	User findByEmail(String email);

	

}