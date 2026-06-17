package com.sedena.app.services;

import java.util.List;

import com.sedena.app.entities.AdoptionRequest;

public interface IService {
	boolean insert(long adopterId, long petId);
	List<AdoptionRequest> findAll();
	boolean delete(long id);
	List<AdoptionRequest> findByemail(String email);

}
