package com.bayram.app.repository.test;

import java.util.ArrayList;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bayram.app.service.RoleService;
import com.bayram.app.service.UserService;
import com.bayram.app.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

	@Autowired
	private UserService userService;
	

	@Autowired
	private RoleService roleService;
	
	@Test
	public void createUser() {
		
		Role roleAdmın=roleService.findRoleById(3);
		Role roleUser=roleService.findRoleById(1);
		
		List<Role> roles=new ArrayList<>();
		roles.add(roleAdmın);
		roles.add(roleUser);
		
		User user=new User();
		user.setFirstName("a");
		user.setLastName("b");
		user.setPassword("sfjkssjd+");
		user.setEmail("av@gmail.com");
		user.setPhoneNumber("8763132164464");
		user.setRoles(roles);
		
		userService.createUser(user);
		
	}
	
	
	
	@Test
	public void testFindUserById() {
		
		User user=userService.findById(3);
		
		System.out.println("user : "+user);
//		System.out.println("user role : "+user.getRoles());
		
	}
	
	@Test
	public void testFindUserByEmail() {
		
		User user=userService.findByEmail("zyasar@gmail.com");
		
		System.out.println("user : "+user);
		System.out.println("user role : "+user.getRoles());
		
	}
	
	
	@Test
	public void testDeleteUser() {
		userService.deleteUser(4);
		
	}
	@Test
	public void testUpdateUser() {
		User user=userService.findById(1);
		user.setActive(true);
	}
	
	
	
	
	
	
	
	
}
