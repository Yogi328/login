package com.prodapt.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.prodapt.demo.entity.Role;
import com.prodapt.demo.entity.User;
import com.prodapt.demo.entity.UserDetails;
import com.prodapt.demo.repository.RoleRepository;
import com.prodapt.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
   
    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
      
    }

    @Override
    public void saveUser(UserDetails userDetails) {
        User user = new User();
        user.setName(userDetails.getFirstName() + " " + userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());


        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDetails> findAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream()
                .map((user) -> mapToUserDetails(user))
                .collect(Collectors.toList());
    }

    private UserDetails mapToUserDetails(User user){
        UserDetails userDto = new UserDetails();
        String[] str = user.getName().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
   
    @Override
	public User getUserDetailsById(long id) {
		Optional<User> optional = userRepository.findById(id);
		User employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		return employee;
	}

	@Override
	public void deleteUserDetailsById(long id) {
		this.userRepository.deleteById(id);
	}
}