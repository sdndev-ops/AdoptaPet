package com.sedena.app.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sedena.app.entities.AdoptionStatus;
import com.sedena.app.entities.Pet;
import com.sedena.app.services.IService;

@RestController
@RequestMapping("/pet")
public class MicroserviceController {
	private IService service;

	public MicroserviceController(IService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<String> insert(@RequestBody Pet p){
		try {
			if(service.insert(p))
				return new ResponseEntity<>("inserted", HttpStatus.OK);
			else
				return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
		}catch(Exception e){
			return new ResponseEntity<>("internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Pet>> findAll(){
		try {
			return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<Pet> findById(@PathVariable("id") long id){
		try {
			
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/specie/{specie}")
	public ResponseEntity<List<Pet>> findBySpecie(@PathVariable("specie") String specie){
		try {
			return new ResponseEntity<>(service.findBySpecie(specie), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

	
	@GetMapping("/adoption/{status}")
	public ResponseEntity<List<Pet>> findByAdoptionStatus(@PathVariable("status") AdoptionStatus status){
		try {
			return new ResponseEntity<>(service.findByAdoptionStatus(status), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	@PutMapping
	public ResponseEntity<String> updateById(@RequestBody Pet p){
		try {
			if(service.update(p))
			  return new ResponseEntity<>("updated", HttpStatus.OK);
			else
				return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	//PatchMapping solo lo implementa OpenFeign de github (ok feign okhttp)
	//@PatchMapping//actualización parcial-> PATCH->http://ip:port/pet?id=id,status=AVAILABLE
	@PutMapping("/status") //Este cambio se realizó para usar Feign de Spring Cloud
	public ResponseEntity<String> updateAdoptionStatus(
			@RequestParam("id") long id, 
			@RequestParam("status") AdoptionStatus status
			){
		try {
			if(service.udpateAdoptionStatus(id, status))
				return new ResponseEntity<>("updated", HttpStatus.OK);
			else
				return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	

}
