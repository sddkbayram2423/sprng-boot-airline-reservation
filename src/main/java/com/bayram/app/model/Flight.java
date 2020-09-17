package com.bayram.app.model;

import java.io.Serializable;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "t_flight")
public class Flight extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "flight_code")
	@NotEmpty(message = "Field cant be empty")
	private String fightCode;

	@Column(name = "operation_airlines")
	@NotEmpty(message = "Field cant be empty")
	private String operatingAirlines;

	@Column(name = "depature_city")
	@NotEmpty(message = "Field cant be empty")
	private String departureCity;
	
	@Column(name = "arrival_city")
	@NotEmpty(message = "Field cant be empty")
	private String arrivalCity;
	

	@Column(name = "deperture_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Field cant be empty etc.(yyyy-MM-dd)")
	private Date departureDate;
	
	@Column(name = "arrival_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Please enter departure date etc.(2020-12-12)")
	private Date arrivalDate;
	
	
	@Column(name = "departure_time")
	@NotEmpty(message = "Please enter departure time (hh:mm PM/AM)")
	private String departureTime;
	
	@Column(name = "arrival_time")
	@NotEmpty(message = "Field cant be empty (hh:mm PM/AM)")
	private String arrivalTime;
	
	@Column(name = "flight_time")
	@NotEmpty(message = "Field cant be empty (hh:mm H/M)")
	private String flightTime;
	
	@Column(name = "flight_class")
	@NotEmpty(message = "Field cant be empty ")
	private String flightClass;
	
	@Column(name = "left_passenger_count")
	@Range(min = 0,message = "Count value must be min  {min} ")
	private int leftPassengerCount;
	
	
	@Column(name = "flight_price")
	@Range(min = 0,message = "Price value must be min  {min}  ")
	private double price=0;
	
	public Flight() {
		

	}


	public String getFightCode() {
		return fightCode;
	}


	public void setFightCode(String fightCode) {
		this.fightCode = fightCode;
	}


	public String getOperatingAirlines() {
		return operatingAirlines;
	}


	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}


	public String getDepartureCity() {
		return departureCity;
	}


	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}


	public String getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public Date getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public String getArrivalTime() {
		return arrivalTime;
	}


	public String getFlightTime() {
		return flightTime;
	}


	public void setFlightTime(String flightTime) {
		this.flightTime = flightTime;
	}


	public String getFlightClass() {
		return flightClass;
	}


	public void setFlightClass(String flightClass) {
		this.flightClass = flightClass;
	}


	public int getLeftPassengerCount() {
		return leftPassengerCount;
	}


	public void setLeftPassengerCount(int leftPassengerCount) {
		this.leftPassengerCount = leftPassengerCount;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Flight [fightCode=" + fightCode + ", operatingAirlines=" + operatingAirlines + ", departureCity="
				+ departureCity + ", arrivalCity=" + arrivalCity + ", departureDate=" + departureDate + ", arrivalDate="
				+ arrivalDate + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", flightTime="
				+ flightTime + ", flightClass=" + flightClass + ", leftPassengerCount=" + leftPassengerCount
				+ ", price=" + price + "]";
	}



	


}
