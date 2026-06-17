package com.sedena.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name="adoption_requests")

public class AdoptionRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private long idPet;
	
	@Column(nullable=false)
	private long adopterId;
	
	@Column(length=50)
	private String namePet;
	
	@Column(length=100)
	private String emailAdopter;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable=false, length=100)
	private AdoptionRequestStatus status;
	
	@PrePersist //Método que se ejecute antes de generar un nuevo registro en la BD
	public void beforeInsert() {
		if(status==null)
			this.status=AdoptionRequestStatus.PENDING;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdPet() {
		return idPet;
	}
	public void setIdPet(long idPet) {
		this.idPet = idPet;
	}
	public long getAdopterId() {
		return adopterId;
	}
	public void setAdopterId(long adopterId) {
		this.adopterId = adopterId;
	}
	public String getNamePet() {
		return namePet;
	}
	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}
	public String getEmailAdopter() {
		return emailAdopter;
	}
	public void setEmailAdopter(String emailAdopter) {
		this.emailAdopter = emailAdopter;
	}
	public AdoptionRequestStatus getStatus() {
		return status;
	}
	public void setStatus(AdoptionRequestStatus status) {
		this.status = status;
	}
	
}
