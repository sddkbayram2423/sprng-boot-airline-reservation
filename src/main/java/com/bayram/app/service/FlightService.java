package com.bayram.app.service;



import java.util.Date;
import java.util.List;

import com.bayram.app.model.Flight;
import com.bayram.app.model.dto.FlightDto;

public interface FlightService {


	Flight findById(long id);

	Flight updateFlight(Flight flight);

	void createFlight(Flight flight);

	void deleteFlight(long id);
	
	List<Flight> findFlights(String from,  String to, Date dateOfDeparture);
	
	List<Flight> getAllFligtList(FlightDto flightDto);
	
	List<Flight> findAll();

}
