package com.sedena.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//Habilitar comunicación con otros microservicios
@EnableFeignClients

@SpringBootApplication
public class MicroserviceAdoptionRequestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAdoptionRequestApplication.class, args);
	}

}
