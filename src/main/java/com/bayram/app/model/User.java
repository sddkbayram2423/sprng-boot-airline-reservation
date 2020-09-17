package com.bayram.app.model;

import java.io.Serializable;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Entity
@Table(name = "t_user")
public class User extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "password",nullable = false)
	private String password;
	
	@Column(name = "email",unique = true,nullable = false)
	@Email(message = "Your mail must contain @ charecter")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "t_user_role",
			joinColumns = {@JoinColumn(name ="user_id")}	,
			inverseJoinColumns =  @JoinColumn(name ="role_id"))
	private List<Role> roles;
	
	@Column(name = "enable")
	private boolean isActive;

	public User() {
		this.isActive=true;
	}

	public User(String firstName, String lastName, String password,
			@Email(message = "Your mail must contain @ charecter") String email, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isActive=true;
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


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber+ "]";
	}
	
	


	
	

}
