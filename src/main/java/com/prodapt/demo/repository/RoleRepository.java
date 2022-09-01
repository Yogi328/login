package com.prodapt.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.demo.entity.Role;
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByName(String name);
}