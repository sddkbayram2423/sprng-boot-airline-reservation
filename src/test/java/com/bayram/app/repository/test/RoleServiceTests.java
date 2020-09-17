package com.bayram.app.repository.test;






import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bayram.app.model.Role;
import com.bayram.app.service.RoleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTests {
	
	
	
	
	@Autowired
	private RoleService roleService;
	
	@Test
	public void createRole() {
		
		Role role=new Role();
		role.setName("ROLE_USER");
		
		Role role1=new Role();
		role1.setName("ROLE_ADMIN");
		
		
//		roleService.createRole(role);
//		roleService.createRole(role1);
		
	}
	
	@Test
	public void testFindRoleById() {
		Role role=roleService.findRoleById(2);
		
		System.out.println("Role : "+role);
		
	}
	
	@Test
	public void testFindByRoleName() {
		
		Role role=roleService.findRoleByName("ROLE_MANAGER");
		System.out.println("ıd :"+role.getId());
		System.out.println("name :"+role.getName());
		
	}

}
