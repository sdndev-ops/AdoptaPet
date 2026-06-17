package com.sedena.app.entities;

public class Adopter {
	private long id;
	private String email;
	private String firstName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "adopter [id=" + id + ", email=" + email + ", firstName=" + firstName + "]";
	}
		
}
