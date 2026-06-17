package com.sedena.app.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.sedena.app.entities.AdoptionRequest;


public interface IMicroserviceDAO extends CrudRepository<AdoptionRequest, Long>{
	
	@Query("SELECT u FROM AdoptionRequest u WHERE u.emailAdopter=:email")
	List<AdoptionRequest> searchByEmailAdopter(@Param("email") String email);

}
