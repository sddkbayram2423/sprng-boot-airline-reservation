package com.bayram.app.repository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bayram.app.model.Passenger;
import com.bayram.app.model.Reservation;
import com.bayram.app.model.dto.ReservationRequest;
import com.bayram.app.service.ReservationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReservationServiceTest {
	
	@Autowired
	private ReservationService reservationService;
	
	@Test
	public void testPdfGeneratinByReservatioon() {
		
		Reservation a = reservationService.findById(1);
		System.out.println(a);
		ReservationRequest reservationRequest=new ReservationRequest();
		Passenger passenger=a.getPassenger();
		
		reservationRequest.setEmail(passenger.getEmail());
		reservationRequest.setFirstName(passenger.getFirstName());
		reservationRequest.setLastName(passenger.getLastName());
		reservationRequest.setFlightId(a.getFlight().getId());
		reservationRequest.setPhoneNumber(passenger.getPhoneNumber());
		
		System.out.println(reservationRequest);
		
		reservationService.bookFlight(reservationRequest);
		
	}
	

}
