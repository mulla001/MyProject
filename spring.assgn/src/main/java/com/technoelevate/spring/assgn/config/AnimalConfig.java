package com.technoelevate.spring.assgn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.technoelevate.spring.assgn.been.Animal;
import com.technoelevate.spring.assgn.been.Cat;
import com.technoelevate.spring.assgn.been.Dog;

import lombok.Data;

@Configuration
public class AnimalConfig {
	@Bean
	public Animal getDog() {
		return new Dog();

	}

	@Bean
	public Animal getCat() {
		return new Cat();

	}

}
