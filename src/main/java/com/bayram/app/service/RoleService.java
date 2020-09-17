package com.bayram.app.service;




import com.bayram.app.model.Role;

public interface RoleService {
	
	Role findRoleById(long id);
	
	Role findRoleByName(String name);

}
