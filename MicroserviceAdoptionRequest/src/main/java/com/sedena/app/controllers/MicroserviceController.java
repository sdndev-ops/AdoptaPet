package com.sedena.app.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sedena.app.entities.AdoptionRequest;
import com.sedena.app.services.IService;

@RestController
@RequestMapping("/adoption")
public class MicroserviceController {
	
	private IService service;
	
	public MicroserviceController(IService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<String> insert(
			@RequestParam("idPet") long idPet,
			@RequestParam("idAdopter") long idAdopter
			){
		try {
			if(service.insert(idAdopter, idPet))
				return new ResponseEntity<>("Created", HttpStatus.CREATED);
			else
				return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping
	public ResponseEntity<List<AdoptionRequest>> findAll(){
		try {
			return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		try {
			if(service.delete(id))
				return new ResponseEntity<>("Deleted", HttpStatus.OK);
			else
				return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
