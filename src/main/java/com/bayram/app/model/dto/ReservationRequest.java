package com.bayram.app.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
@Validated
public class ReservationRequest {

	private long flightId;
	
	@NotEmpty(message = "Firstname field cant be empty")
	private String firstName;
	
	@NotEmpty(message = "Lastname field cant be empty")
	private String lastName;
	
	@Email(message = "Invalid email")
	@NotEmpty(message = "Field cant be empty")
	private String email;
	
	@NotEmpty(message = "Field cant be empty")
	@Size(max = 11,min = 11,message = "Fied must be {min} number")
	private String phoneNumber;
	
	@NotEmpty(message = "Field cant be empty")
	@Size(max = 16,min = 16,message = "Fied must be {min} number")
	private String cardNumber;
	
	@NotEmpty(message = "Field cant be empty")
	private String nameOnCard;
	
	@Range(min = 0,max = 12,message = "Field must be betwen {min}-{max}")
	private int expiryDateMonth;
	
	@Range(min = 20,max = 99,message = "Field must be betwen {min}-{max}")
	private int expiryDateYear;
	
	@Range(min = 99,max = 999,message = "Field must be betwen {min}-{max}")
	private int securityCode;
	
	private Boolean checkedIn;
	
	private int numberOfBags;
	
	public ReservationRequest() {
	}

	public ReservationRequest(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public long getFlightId() {
		return flightId;
	}

	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public int getExpiryDateMonth() {
		return expiryDateMonth;
	}

	public void setExpiryDateMonth(int expiryDateMonth) {
		this.expiryDateMonth = expiryDateMonth;
	}

	public int getExpiryDateYear() {
		return expiryDateYear;
	}

	public void setExpiryDateYear(int expiryDateYear) {
		this.expiryDateYear = expiryDateYear;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public Boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(Boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBags() {
		return numberOfBags;
	}

	public void setNumberOfBags(int numberOfBags) {
		this.numberOfBags = numberOfBags;
	}

	@Override
	public String toString() {
		return "ReservationRequest [flightId=" + flightId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + ", cardNumber=" + cardNumber + ", nameOnCard="
				+ nameOnCard + ", expiryDateMonth=" + expiryDateMonth + ", expiryDateYear=" + expiryDateYear
				+ ", securityCode=" + securityCode + ", checkedIn=" + checkedIn + ", numberOfBags=" + numberOfBags
				+ "]";
	}

	


}
