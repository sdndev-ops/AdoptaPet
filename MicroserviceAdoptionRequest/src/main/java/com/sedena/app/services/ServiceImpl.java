package com.sedena.app.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;

import com.sedena.app.daos.IMicroserviceDAO;
import com.sedena.app.entities.Adopter;
import com.sedena.app.entities.AdoptionRequest;
import com.sedena.app.entities.AdoptionStatus;
import com.sedena.app.entities.Pet;
import com.sedena.app.feign.IAdopterFeign;
import com.sedena.app.feign.IPetFeign;

@Service
public class ServiceImpl implements IService{
	
	/* Este objeto sirve para auditar código y registrar sucesos*/
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceImpl.class);
	private IMicroserviceDAO dao;
	private IPetFeign feignPet;
	private IAdopterFeign feignAdopter;
	
	
	public ServiceImpl(IMicroserviceDAO dao, IPetFeign feignPet, IAdopterFeign feignAdopter) {
		this.dao = dao;
		this.feignPet = feignPet;
		this.feignAdopter = feignAdopter;
	}
	
	@Override
	public boolean insert(long adopterId, long petId) {
		try {
			Pet petReturned=feignPet.findById(petId);
			LOGGER.info("MICROSERVICEPET>>>>>> {}", petReturned.toString());
			
			Adopter adopterReturned=feignAdopter.findById(adopterId);
			LOGGER.info("MICROSERVICEADOPTER>>>>>> {}", adopterReturned.toString());
			
			if(petReturned.getAdoptionStatus().equals(AdoptionStatus.AVAILABLE)) {
				AdoptionRequest request=new AdoptionRequest();
				request.setAdopterId(adopterReturned.getId());
				request.setEmailAdopter(adopterReturned.getEmail());
				request.setNamePet(petReturned.getName());
				request.setIdPet(petReturned.getId());
				
				feignPet.updateAdoptionStatus(petReturned.getId(), AdoptionStatus.IN_PROCESS);
				return dao.save(request)!=null;
			}else {
				throw new NoSuchElementException("La mascota no está disponible");
			}
			
		}catch(feign.FeignException.NotFound e) {
			LOGGER.warn("ERROR_GET_DATA {}", e.getMessage());
			throw new NoSuchElementException(e.getMessage());
		}catch(feign.FeignException.InternalServerError e) {
			LOGGER.error("ERROR {}", e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
	}


	@Override
	public List<AdoptionRequest> findAll() {
		return (List<AdoptionRequest>) dao.findAll();
	}


	@Override
	public boolean delete(long id) {
		if(dao.existsById(id)) {
			dao.deleteById(id);
			return true;
		}
		throw new NoSuchElementException();
	}


	@Override
	public List<AdoptionRequest> findByemail(String email) {
		return dao.searchByEmailAdopter(email);
	}



	
}