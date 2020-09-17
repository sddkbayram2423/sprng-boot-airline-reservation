package com.bayram.app.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bayram.app.model.Flight;
import com.bayram.app.model.Passenger;
import com.bayram.app.model.Reservation;
import com.bayram.app.model.dto.ReservationRequest;
import com.bayram.app.repository.ReservationRepository;
import com.bayram.app.service.FlightService;
import com.bayram.app.service.PassengerService;
import com.bayram.app.service.ReservationService;
import com.bayram.app.utils.PdfGenerator;
@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	private PassengerService passengerService;
	
	@Autowired
	private PdfGenerator pdfGenerator;

	@Override
	public Reservation bookFlight(ReservationRequest reservationRequest) {
		
		Flight flight=flightService.findById(reservationRequest.getFlightId());
		
		Passenger passenger=new Passenger();
		passenger.setFirstName(reservationRequest.getFirstName());
		passenger.setLastName(reservationRequest.getLastName());
		passenger.setEmail(reservationRequest.getEmail());
		passenger.setPhoneNumber(reservationRequest.getPhoneNumber());
		
		Passenger passenger1 = passengerService.createPassenger(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(passenger1);
		reservation.setCheckedIn(false);
		
		
		Reservation savedReservation=reservationRepository.save(reservation);
		
		String path="D:\\";
		String filePath = path +savedReservation.getPassenger().getFirstName()+savedReservation.getPassenger().getLastName()+savedReservation.getId()+ ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		return savedReservation;
	}

	@Override
	public Reservation findById(long id) {
		return reservationRepository.findById(id);
	}

}
