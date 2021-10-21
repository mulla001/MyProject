package com.technoelevate.spring.assgn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
@Data
@Configuration
public class PetConfig {
	@Bean
	public PetConfig gtPet() {
		return new PetConfig();
		
	}

}
