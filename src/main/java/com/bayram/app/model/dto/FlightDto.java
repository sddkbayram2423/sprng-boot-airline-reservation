package com.bayram.app.model.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
@Validated
public class FlightDto{
	
	@NotEmpty(message = "Please enter airport or city name")
	private String origin;
	
	@NotEmpty(message = "Please enter airport or city name")
	private String destination;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please enter departure date *(2020-12-12)")
	private Date departureDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date returnDate;
	
	@NotNull(message = "Please select trip type")
	private String tripType;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getTripType() {
		return tripType;
	}

	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	
	

	@Override
	public String toString() {
		return "FlightDto [origin=" + origin + ", destination=" + destination + ", departureDate=" + departureDate
				+ ", returnDate=" + returnDate + ", tripType=" + tripType  + "]";
	}

	
	
	
	
}
