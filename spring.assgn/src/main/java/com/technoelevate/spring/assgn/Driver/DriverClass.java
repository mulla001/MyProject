package com.technoelevate.spring.assgn.Driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.technoelevate.spring.assgn.been.Pet;

public class DriverClass {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("com.technoelevate.spring.assgn");
		Pet pet = context.getBean("pet", Pet.class);
		System.out.println(pet);
		pet.getDog().sleep();
		pet.getDog().eating();
		pet.getCat().sleep();
		pet.getCat().eating();
		pet.getCat().getName();

	}

}
