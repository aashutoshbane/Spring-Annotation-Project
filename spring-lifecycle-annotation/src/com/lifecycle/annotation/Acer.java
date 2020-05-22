/**
 * 
 */
package com.lifecycle.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

/**
 * @author Ashutosh Bane
 *
 */
@Component
// @Scope("prototype") this will not invoke preDestroy method
public class Acer implements ILaptop {
	
	@Override
	public String getConfiguration() {
		return "This is 4GB RAM, i3 intel processor, 512 HD";
	}
	
	// init method
	@PostConstruct
	public void initStuff() {
		System.out.println("Init stuff...\n");
	}
	
	// destroy method
	@PreDestroy
	public void destroyStuff() {
		System.out.println("\nDestroy stuff...");
	}
}
