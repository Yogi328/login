package com.prodapt.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.demo.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserName(String userName);
   
}