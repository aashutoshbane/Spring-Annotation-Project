package com.lifecycle.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lifecycle.annotation.ILaptop;

public class SpringMainApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// singleton scope
		ILaptop oldHpGeneration = context.getBean("hpLaptop", ILaptop.class);
		ILaptop newHpGeneration = context.getBean("hpLaptop", ILaptop.class);

		boolean hpResult = (oldHpGeneration == newHpGeneration);
		System.out.println("Object comparison scope bean");
		System.out.println("Pointing to same object: " + hpResult);
		System.out.println("Memory location of oldHpGeneration: " + oldHpGeneration);
		System.out.println("Memory location of newHpGeneration: " + newHpGeneration + "\n");

		// prototype scope
		ILaptop oldDellGeneration = context.getBean("dellLaptop", ILaptop.class);
		ILaptop newDellGeneration = context.getBean("dellLaptop", ILaptop.class);

		boolean dellResult = (oldDellGeneration == newDellGeneration);
		System.out.println("Object comparison of prototype scope bean");
		System.out.println("Pointing to same object: " + dellResult);
		System.out.println("Memory location of oldDellGeneration: " + oldDellGeneration);
		System.out.println("Memory location of newDellGeneration: " + newDellGeneration);

		// close the context
		context.close();
	}

}
