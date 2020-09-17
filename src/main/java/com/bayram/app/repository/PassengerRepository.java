package com.bayram.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bayram.app.model.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
	
	Passenger findById(long id);
	
	Passenger findByEmail(String email);
	
	Passenger findByLastName(String lastName);
	
	Passenger findByPhoneNumber(String phoneNumber);
	
	
	
	
	
	

}
