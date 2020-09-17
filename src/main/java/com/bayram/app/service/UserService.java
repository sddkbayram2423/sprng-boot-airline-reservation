package com.bayram.app.service;

import com.bayram.app.model.User;
import com.bayram.app.model.dto.UserDto;

public interface UserService {
	
	User findById(long id);
	
	User findByEmail(String email);
	
	User createUser(User user);
	
	void deleteUser(long id);
	
	User updateUser(User user);
	
	User saveUser(UserDto userDto);

}
