package com.sedena.app;


import java.time.Duration;

import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;

//Para que se cargue al inicio del microservicio
@Configuration
public class CustomResilience {
	
	//Define un objeto en tiempo de ejecución
	@Bean
	// Se personalizan las reglas de CircuitBreaker
	public Customizer<Resilience4JCircuitBreakerFactory> custom() {
		return factory -> factory.configureDefault(id->{
			if(id.equals("circuit1")) { //solo circuito 1
				return new Resilience4JConfigBuilder(id)
						.circuitBreakerConfig(
								CircuitBreakerConfig.custom()
								.slidingWindowSize(20)
								.failureRateThreshold(50)
								.waitDurationInOpenState(Duration.ofSeconds(10))
								.permittedNumberOfCallsInHalfOpenState(4)
								.build()
								).build();
			} else { //Para cualquier otro circuito
				return new Resilience4JConfigBuilder(id)
						.circuitBreakerConfig(
								CircuitBreakerConfig.custom()
								.slidingWindowSize(50)
								.failureRateThreshold(50)
								.waitDurationInOpenState(Duration.ofSeconds(30))
								.permittedNumberOfCallsInHalfOpenState(5)
								.build()
								).build();
			}
		});
	}
	
}
