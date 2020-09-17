package com.bayram.app.service.Impl;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.app.model.Role;
import com.bayram.app.repository.RoleRepository;
import com.bayram.app.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findRoleById(long id) {
		return roleRepository.findRoleById(id);
	}

	@Override
	public Role findRoleByName(String name) {
		
		return roleRepository.findRoleByName(name);
	}


}
