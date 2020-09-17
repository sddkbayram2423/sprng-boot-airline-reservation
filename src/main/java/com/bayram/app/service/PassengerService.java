package com.bayram.app.service;

import java.util.List;

import com.bayram.app.model.Passenger;

public interface PassengerService {

	Passenger findById(long id);

	Passenger createPassenger(Passenger passenger);

	Passenger updatePassenger(Passenger passenger);

	void deletePassenger(long passengerid);

	List<Passenger> findAll();

	Passenger findByEmail(String email);


}
