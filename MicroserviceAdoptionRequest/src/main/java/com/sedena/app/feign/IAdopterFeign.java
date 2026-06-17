package com.sedena.app.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sedena.app.entities.Adopter;

//before Eureka
//@FeignClient(name="microserviceadopter", url="http://localhost:9092")

//AFTER Eureka
@FeignClient(name="microserviceadopter")
public interface IAdopterFeign {
	
	@GetMapping("/adopter/id/{id}")
	Adopter findById(@PathVariable("id") long id);
	
}
