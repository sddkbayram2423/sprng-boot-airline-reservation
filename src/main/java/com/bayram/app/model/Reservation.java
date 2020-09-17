package com.bayram.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_reservation")
public class Reservation extends BaseEntity {
	
	private Boolean checkedIn;
	
	@Column(name ="weight_of_bags")
    private Integer numberOfBags;

    @OneToOne
    private Passenger passenger;
    
    @OneToOne
    private Flight flight;
    
    public Reservation() {
	}
    
	public Boolean getCheckedIn() {
		return checkedIn;
	}
	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}
	public Integer getNumberOfBags() {
		return numberOfBags;
	}
	public void setNumberOfBags(Integer numberOfBags) {
		this.numberOfBags = numberOfBags;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
    
    

}
