package com.technoelevate.spring.assgn.been;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Dog implements Animal {
	@Value("Tommy")
	private String name;
	@Value("Medium")
	private String type;


	@Override
	public void sleep() {

		System.out.println("Dog is Speeping");
	}

	@Override
	public void eating() {
		System.out.println("Dog is Eating");
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", type=" + type + "]";
	}

}
