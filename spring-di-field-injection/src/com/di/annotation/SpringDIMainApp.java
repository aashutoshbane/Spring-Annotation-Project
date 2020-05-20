package com.di.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.di.annotation.IAccount;

public class SpringDIMainApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		IAccount savingAccount = context.getBean("savingAccount", IAccount.class);

		// call methods on the bean
		System.out.println(savingAccount.createAccount());

		// call methods on the DI
		System.out.println("Interest rate is " + savingAccount.getInterestRate("savings") + "%");

		// retrieve bean from spring container
		IAccount currentAccount = context.getBean("currentAccount", IAccount.class);

		// call methods on the bean
		System.out.println(currentAccount.createAccount());

		// call methods on the DI
		System.out.println("Interest rate is " + currentAccount.getInterestRate("homeloan") + "%");

		// close the context
		context.close();
	}

}
