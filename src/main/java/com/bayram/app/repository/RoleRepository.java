package com.bayram.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bayram.app.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findRoleById(long id);
	
	Role findRoleByName(String name);
	
	
	
}
