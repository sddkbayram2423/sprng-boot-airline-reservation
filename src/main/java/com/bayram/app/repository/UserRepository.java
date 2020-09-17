package com.bayram.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bayram.app.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findById(long id);
	
	User findByEmail(String email);
	

}
