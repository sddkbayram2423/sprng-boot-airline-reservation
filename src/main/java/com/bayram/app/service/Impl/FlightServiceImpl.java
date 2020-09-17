package com.bayram.app.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bayram.app.model.Flight;
import com.bayram.app.model.dto.FlightDto;
import com.bayram.app.repository.FlightRepository;
import com.bayram.app.service.FlightService;


@Repository
public class FlightServiceImpl implements FlightService {
	
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight findById(long id) {
		
		return flightRepository.findById(id);
	}

	@Override
	public Flight updateFlight(Flight flight) {
		return flightRepository.save(flight);
	}

	@Override
	public void createFlight(Flight flight) {
		 
		flightRepository.save(flight);
	}

	@Override
	public void deleteFlight(long id) {
		 
		flightRepository.delete(findById(id));
	}

	@Override
	public List<Flight> findFlights(String from, String to, Date dateOfDeparture) {
		 
		return flightRepository.findFlights(from, to, dateOfDeparture);
	}
	
	
	
	public List<Flight> getAllFligtList(FlightDto flightDto){

		List<Flight> flightListByDapraturedDate=new ArrayList<>();
		List<Flight> flightListByReturnedDate=new ArrayList<>();
		List<Flight> flightsAllList=new ArrayList<>();
		
		
		if(flightDto.getTripType().equals("OneWay")) {
			
			flightListByDapraturedDate=this.findFlights(flightDto.getOrigin(), flightDto.getDestination(), flightDto.getDepartureDate());
			
			for (Flight flight : flightListByDapraturedDate) {
				flightsAllList.add(flight);				
			}
			
		}else if(flightDto.getTripType().equals("RoundTrip")){
			
			flightListByDapraturedDate=this.findFlights(flightDto.getOrigin(), flightDto.getDestination(), flightDto.getDepartureDate());
			flightListByReturnedDate=this.findFlights( flightDto.getDestination(),flightDto.getOrigin(), flightDto.getReturnDate());
			
			for (Flight flight : flightListByDapraturedDate) {
				flightsAllList.add(flight);				
			}
			
			for (Flight flight : flightListByReturnedDate) {
				flightsAllList.add(flight);				
			}
		}	
		return flightsAllList;

	}

	@Override
	public List<Flight> findAll() {
		return flightRepository.findAll();
	}
	
	
}