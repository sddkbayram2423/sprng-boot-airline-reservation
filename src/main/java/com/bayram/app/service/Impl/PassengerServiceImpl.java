package com.bayram.app.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.app.model.Passenger;
import com.bayram.app.repository.PassengerRepository;
import com.bayram.app.service.PassengerService;
@Service
public class PassengerServiceImpl implements PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public Passenger findById(long id) {
		return passengerRepository.findById(id);
	}

	@Override
	public Passenger createPassenger(Passenger passenger) {
		return passengerRepository.save(passenger);
		
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		
		return passengerRepository.save(passenger);
	}

	@Override
	public void deletePassenger(long passengerid) {
		passengerRepository.delete(findById(passengerid));
		
	}

	@Override
	public List<Passenger> findAll() {
		
		return passengerRepository.findAll();
	}

	@Override
	public Passenger findByEmail(String email) {
		
		return passengerRepository.findByEmail(email);
	}

}
