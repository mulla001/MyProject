package com.technoelevate.spring.assgn.been;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Configuration
public class Cat implements Animal {
	@Value("Catie")
	private String name;
	@Value("Small")
	private String type;

	@Override
	public void sleep() {
		System.out.println("Cat is Sleeping");
	}

	@Override
	public void eating() {
		System.out.println("Cat is Eating");
	}

}
