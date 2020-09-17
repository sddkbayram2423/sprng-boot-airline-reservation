package com.bayram.app.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bayram.app.validator.PasswordMatches;
@Validated
@PasswordMatches(first = "password", second = "passwordRepeat",message = "Password fields not matched")
public class UserDto {
	
	
	@NotEmpty(message = "Firstname field cant be empty")
	private String firstName;
	
	@NotEmpty(message = "Lastname field cant be empty")
	private String lastName;
	
	@Email(message = "Invalid email")
	@NotEmpty(message = "Email field cant be empty")
	private String email;
	
	@Size(min = 4,message = "Password size must be min {min} ")
	@NotEmpty(message = "Your password field cant be empty")
	
	@Size(min = 4,message = "Password size must be min {min} ")
	@NotEmpty(message = "Your password field cant be empty")
	private String password;
	
	@Size(min = 4,message = "Password size must be min {min} ")
	@NotEmpty(message = "Your password repeat field cant be empty")
	private String passwordRepeat;
	
	
	@NotEmpty(message = "Phone number field cant be empty")
	private String phoneNumber;
	
	public UserDto() {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}

	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", passwordRepeat=" + passwordRepeat + ", phoneNumber=" + phoneNumber + "]";
	}
	

}
