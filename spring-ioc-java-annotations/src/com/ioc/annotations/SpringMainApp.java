package com.ioc.annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ashutosh Bane
 *
 */
public class SpringMainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/**
		 * Bean id defined
		 */
		// retrieve bean from spring container
		ICountry myCountry = context.getBean("theIndia", ICountry.class);

		// call methods on the bean
		System.out.println("The one with bean id mentioned");
		System.out.println(myCountry.getCapital());
		
		/**
		 * Deafult bean id
		 */
		// retrieve bean from spring container
		ICountry theKiwis = context.getBean("newZealand", ICountry.class);

		// call methods on the bean
		System.out.println("\nThe one with default bean id");
		System.out.println(theKiwis.getCapital());
		

		// close the context
		context.close();

	}

}
