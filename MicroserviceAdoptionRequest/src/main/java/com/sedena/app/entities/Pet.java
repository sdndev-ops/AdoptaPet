package com.sedena.app.entities;


/*
 * Esta clase traer los datos del microservicio pet 
 */
public class Pet {
	private long id;
	private String name;
	private AdoptionStatus adoptionStatus;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AdoptionStatus getAdoptionStatus() {
		return adoptionStatus;
	}
	public void setAdoptionStatus(AdoptionStatus adoptionStatus) {
		this.adoptionStatus = adoptionStatus;
	}
	
	@Override
	public String toString() {
		return "pet [id=" + id + ", name=" + name + ", adoptionStatus=" + adoptionStatus + "]";
	}
	
	
	
}
