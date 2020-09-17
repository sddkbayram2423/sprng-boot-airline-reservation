package com.bayram.app.service.Impl;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bayram.app.model.Role;
import com.bayram.app.model.User;
import com.bayram.app.model.dto.UserDto;
import com.bayram.app.repository.UserRepository;
import com.bayram.app.service.RoleService;
import com.bayram.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleService roleService;


	@Override
	public User findById(long id) {
		return userRepository.findById(id);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User createUser(User user) {
		
		Role role=roleService.findRoleById(2);
		user.setRoles(Arrays.asList(role));
		
		return userRepository.save(user);
		
	}

	@Override
	public void deleteUser(long id) {
		User entity=findById(id);
		userRepository.delete(entity);
		
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User saveUser(UserDto userDto) {
		
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPhoneNumber(userDto.getPhoneNumber());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		return this.createUser(user);
	}

}
