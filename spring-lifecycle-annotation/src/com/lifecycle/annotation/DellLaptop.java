package com.lifecycle.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DellLaptop implements ILaptop {

	@Override
	public String getConfiguration() {
		return "This is 8GB RAM, i7 intel processor, 512 SSD";
	}

}
