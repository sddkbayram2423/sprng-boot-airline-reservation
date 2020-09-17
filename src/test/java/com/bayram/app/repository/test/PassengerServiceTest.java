package com.bayram.app.repository.test;

import java.util.List;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bayram.app.model.Flight;
import com.bayram.app.model.Passenger;
import com.bayram.app.service.PassengerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PassengerServiceTest {

	@Autowired
	private PassengerService passengerService;

	@Test
	public void createPassenger() {

		
		Flight flight=new Flight();
		flight.setArrivalTime("10:30");
		
		Passenger passenger = new Passenger();
		passenger.setEmail("passenger1@gmail.com");
		passenger.setFirstName("Ali");
		passenger.setLastName("Kaya");
		passenger.setPhoneNumber("03213215411");

		Passenger passenger1 = new Passenger();
		passenger1.setEmail("passenger3@gmail.com");
		passenger1.setFirstName("Hazal");
		passenger1.setLastName("Ant");
		passenger1.setPhoneNumber("09352602143");

		Passenger passenger2 = new Passenger();
		passenger2.setEmail("passenger2@gmail.com");
		passenger2.setFirstName("Bahar");
		passenger2.setLastName("Sevgi");
		passenger2.setPhoneNumber("03214785411");
		

		passengerService.createPassenger(passenger);
		passengerService.createPassenger(passenger1);
		passengerService.createPassenger(passenger2);

	}

	@Test
	public void findById() {
		
		Passenger passenger=passengerService.findById(3);
		System.out.println(passenger.getEmail());
		System.out.println(passenger.getFirstName());
		System.out.println(passenger.getLastName());
		System.out.println(passenger.getId());

	}
	@Test
	public void findByEmail() {
		Passenger passenger=passengerService.findByEmail("passenger1@gmail.com");
		System.out.println(passenger.getEmail());
		System.out.println(passenger.getFirstName());
		System.out.println(passenger.getLastName());
		System.out.println(passenger.getId());
		
	}

	@Test
	public void updatePassenger() {
		Passenger passenger=passengerService.findById(2);
		
		passengerService.updatePassenger(passenger);

	}

	@Test
	public void deletePassenger() {
		
		passengerService.deletePassenger(7);
		passengerService.deletePassenger(8);

	}

	@Test
	public void findAll() {
		
		List<Passenger> list = passengerService.findAll();
		for (Passenger passenger : list) {
			System.out.println(passenger);
		}

	}

}
