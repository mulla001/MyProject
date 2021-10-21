package com.technoelevate.spring.assgn.been;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class Pet {
	@Value("Sharath")
	private String name;
	@Autowired
	private Cat cat;
	@Autowired
	private Dog dog;

}
