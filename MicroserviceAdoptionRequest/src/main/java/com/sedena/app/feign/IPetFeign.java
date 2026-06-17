package com.sedena.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sedena.app.entities.AdoptionStatus;
import com.sedena.app.entities.Pet;

//before Eureka
//@FeignClient(name="microservicepet", url="http://localhost:9091")

//AFTER Eureka
@FeignClient(name="microservicepet")
public interface IPetFeign {
	
	//Obtener el Id mascota
	@GetMapping("/pet/id/{id}")
	Pet findById(@PathVariable("id") long id);
	
	//Actualizar el status de adopción de mascota 
	@PutMapping("/pet/status")
	String updateAdoptionStatus(
			@RequestParam("id") long id,
			@RequestParam("status") AdoptionStatus status
			);
	
	
	
	
}
